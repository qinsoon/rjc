/*
 *  This file is part of the Jikes RVM project (http://jikesrvm.org).
 *
 *  This file is licensed to You under the Eclipse Public License (EPL);
 *  You may not use this file except in compliance with the License. You
 *  may obtain a copy of the License at
 *
 *      http://www.opensource.org/licenses/eclipse-1.0.php
 *
 *  See the COPYRIGHT.txt file distributed with this work for information
 *  regarding copyright ownership.
 */
package org.mmtk.policy;

import org.mmtk.plan.markcompact.MC;
import org.mmtk.utility.Log;
import org.mmtk.utility.alloc.Allocator;
import org.mmtk.utility.alloc.BumpPointer;
import org.mmtk.vm.VM;
import org.vmmagic.pragma.Inline;
import org.vmmagic.pragma.Uninterruptible;
import org.vmmagic.unboxed.Address;
import org.vmmagic.unboxed.Extent;
import org.vmmagic.unboxed.ObjectReference;

/**
 * This class implements unsynchronized (local) per-collector-thread elements of a
 * sliding mark-compact collector.<p>
 *<p>
 * Specifically, this class provides the methods that
 * <ul>
 *  <li>Calculate the forwarding pointers for heap objects, in a linear pass over
 *   (part of) the heap</li>
 *  <li>Performs the compaction pass over the heap.</li>
 * </ul>
 *<p>
 * Each collector thread maintains a private list of the pages that it compacts.
 * If it runs out of work during the calculateForwardingPointers pass, it requests
 * a new region from the global MarkCompactSpace.  Regions compacted by a collector
 * remain local to the collector.
 *
 * @see MarkCompactSpace
 * @see MarkCompactLocal
 */
@Uninterruptible
public final class MarkCompactCollector {

  static final boolean VERBOSE = false;

  static final boolean VERY_VERBOSE = VERBOSE && false;

  private final MarkCompactSpace space;

  /**
   * This collector's work list
   */
  private Address regions = Address.zero();

  private final MarkCompactCollectorFromCursor fromCursor = new MarkCompactCollectorFromCursor();
  private final MarkCompactCollectorToCursor toCursor = new MarkCompactCollectorToCursor();

  /**
   * Constructor
   *
   * @param space The space to bump point into.
   */
  public MarkCompactCollector(MarkCompactSpace space) {
    this.space = space;
  }

  /* ********************************************************************************
   *
   *                Cursor classes
   *
   */







  /* ***************************************************************************************** */

  /**
   * Perform a linear scan through the objects allocated by this bump pointer,
   * calculating where each live object will be post collection.<p>
   *
   * We maintain two cursors, {@code fromCursor} and {@code toCursor}, and simulate
   * copying live objects from the former to the latter.  Initially, the cursors
   * point to the first region in this collector's local list, and increment in
   * lockstep until the first dead object is encountered.  After that, the to cursor
   * trails the from cursor.<p>
   *
   * The outer loop advances the 'from' pointer
   */
  public void calculateForwardingPointers() {
    if (regions.isZero()) {
      regions = space.getNextRegion();
    }

    if (regions.isZero())
      return;

    fromCursor.init(regions);
    toCursor.init(regions);

    if (VM.VERIFY_ASSERTIONS) VM.assertions._assert(true);

    /* Loop through active regions or until the last region */
    while (fromCursor.isValid()) {
      if (VERBOSE) {
        fromCursor.print();
        toCursor.print();
      }

      /* Loop through the objects in the current 'from' region */
      while (fromCursor.hasMoreObjects()) {
        ObjectReference current = fromCursor.advanceToObject();
        fromCursor.advanceToObjectEnd(current);

        if (MarkCompactSpace.toBeCompacted(current)) {
          if (VM.VERIFY_ASSERTIONS) VM.assertions._assert(MarkCompactSpace.getForwardingPointer(current).isNull());

          // Fake - allocate it.
          int size = VM.objectModel.getSizeWhenCopied(current);
          int align = VM.objectModel.getAlignWhenCopied(current);
          int offset = VM.objectModel.getAlignOffsetWhenCopied(current);
          // Move to the (aligned) start of the next object
          toCursor.incTo(Allocator.alignAllocationNoFill(toCursor.get(), align, offset));

          /*
           * If we're allocating into separate regions, and we've allocated beyond the end of the
           * current region, advance to the next one.  We always allocate into regions we have
           * scanned in this collector.
           */
          if (!toCursor.sameRegion(fromCursor) && !toCursor.isAvailable(size)) {
            // The 'to' pointer always trails the 'from' pointer, guaranteeing that
            // there's a next region to advance to.
            toCursor.advanceToNextRegion();
            toCursor.incTo(Allocator.alignAllocationNoFill(toCursor.get(), align, offset));
          }

          ObjectReference target = VM.objectModel.getReferenceWhenCopiedTo(current, toCursor.get());
          if (toCursor.sameRegion(fromCursor) && target.toAddress().GE(current.toAddress())) {
            // Don't move the object.
            MarkCompactSpace.setForwardingPointer(current, current);
            toCursor.incTo(VM.objectModel.getObjectEndAddress(current));
          } else {
            MarkCompactSpace.setForwardingPointer(current, target);
            toCursor.inc(size);
          }
        }
      }
      fromCursor.advanceToNextForwardableRegion(space);
    }
  }


  /**
   * Perform the compacting phase of the collection.
   */
  public void compact() {
    if (regions.isZero()) return;

    toCursor.init(regions);
    fromCursor.init(regions);

    /* Loop through active regions or until the last region */
    while (fromCursor.isValid()) {
      if (VERBOSE) {
        Log.write("Compacting from region "); Log.write(fromCursor.getRegion());
        Log.write(" to region "); Log.writeln(toCursor.getRegion());
      }

      /* Loop through the objects in the region */
      while (fromCursor.hasMoreObjects()) {
        ObjectReference current = fromCursor.advanceToObject();
        fromCursor.advanceToObjectEnd(current);

        ObjectReference copyTo = MarkCompactSpace.getForwardingPointer(current);
        if (VM.VERIFY_ASSERTIONS) VM.assertions._assert(!copyTo.toAddress().EQ(Address.fromIntZeroExtend(VM.ALIGNMENT_VALUE)));

        if (!copyTo.isNull() && Space.isInSpace(MC.MARK_COMPACT, copyTo)) {
          if (VM.VERIFY_ASSERTIONS) {
            if (MarkCompactSpace.isMarked(current)) {
              Log.write("Object "); Log.write(current);
              Log.writeln(" is marked during the compact phase");
              VM.objectModel.dumpObject(current);
            }
            VM.assertions._assert(!MarkCompactSpace.isMarked(current));
          }
          if (!toCursor.isInRegion(copyTo)) {
            // Update metadata and move on
            toCursor.finishAndAdvanceToNextRegion();
          }
          if (VM.VERIFY_ASSERTIONS) VM.assertions._assert(toCursor.isInRegion(copyTo));
          toCursor.copy(current, copyTo);
          if (VM.VERIFY_ASSERTIONS) VM.assertions._assert(toCursor.isInRegion(copyTo));
          MarkCompactSpace.setForwardingPointer(copyTo, ObjectReference.nullReference());
        }
      }
      fromCursor.advanceToNextRegion();
    }

    /* Fix up the last object pointer etc */
    toCursor.finish();


    /*
     * Return unused pages to the global page resource
     */
    Address region = toCursor.snip();
    while (!region.isZero()) {
      Address nextRegion = MarkCompactLocal.getNextRegion(region);
      space.release(region);
      region = nextRegion;
    }
  }
}
