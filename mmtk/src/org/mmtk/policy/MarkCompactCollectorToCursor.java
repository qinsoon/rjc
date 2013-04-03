package org.mmtk.policy;

import org.mmtk.utility.Log;
import org.mmtk.utility.alloc.BumpPointer;
import org.mmtk.vm.VM;
import org.vmmagic.pragma.Inline;
import org.vmmagic.pragma.Uninterruptible;
import org.vmmagic.unboxed.Address;
import org.vmmagic.unboxed.Extent;
import org.vmmagic.unboxed.ObjectReference;

/**
 * Subclass for the read-only cursor that follows the 'from' cursor,
 * writing or calculating the position of copied objects
 */
@Uninterruptible
public final class MarkCompactCollectorToCursor extends MarkCompactCollectorRegionCursor {
  public MarkCompactCollectorToCursor() {
    super("to");
  }

  /**
   * Initialize the cursor to a given region.  The limit is the limit of
   * available space in the region.
   */
  @Override
  void init(Address region) {
    if (VM.VERIFY_ASSERTIONS) BumpPointer.checkRegionMetadata(region);
    this.region = region;
    this.cursor = MarkCompactLocal.getDataStart(region);
    this.limit = MarkCompactLocal.getRegionLimit(region);
    if (VM.VERIFY_ASSERTIONS) assertCursorInBounds();
  }

  /**
   * Update the metadata of the current region with the current value
   * of the cursor.  Zero the region from here to the end.
   */
  void finish() {
    if (VM.VERIFY_ASSERTIONS) assertCursorInBounds();
    Extent zeroBytes = limit.diff(cursor).toWord().toExtent();
    VM.memory.zero(false, cursor, zeroBytes);
    MarkCompactLocal.setDataEnd(region, cursor);
    MarkCompactLocal.checkRegionMetadata(region);
  }

  /**
   * Terminate the list of regions here.
   * @return The address of the (old) next region in the list.
   */
  Address snip() {
    Address nextRegion = BumpPointer.getNextRegion(region);
    BumpPointer.clearNextRegion(region);
    finish();
    return nextRegion;
  }

  /**
   * Copy an object to an address within this cursor's region.
   * @param from The source object
   * @param to The target object
   */
  @Inline
  void copy(ObjectReference from, ObjectReference to) {
    if (VM.VERIFY_ASSERTIONS) {
      VM.assertions._assert(MarkCompactSpace.getForwardingPointer(from).toAddress().EQ(to.toAddress()));
      VM.assertions._assert(cursor.GT(region) && cursor.LE(limit));
    }
    Address savedCursor = Address.zero();
    if (VM.VERIFY_ASSERTIONS) savedCursor = cursor;
    cursor = VM.objectModel.copyTo(from, to, cursor);
    if (VM.VERIFY_ASSERTIONS) {
      if (cursor.LT(BumpPointer.getDataStart(region)) || cursor.GT(limit)) {
        Log.write("Copy of "); Log.write(from);
        Log.write(" to "); Log.write(to);
        Log.write(" puts cursor at "); Log.write(cursor);
        Log.write(" (was: "); Log.write(savedCursor);
        Log.writeln(")");
      }
      VM.assertions._assert(cursor.GT(region) && cursor.LE(limit));
    }
    MarkCompactSpace.setForwardingPointer(to, ObjectReference.nullReference());
    if (VM.VERIFY_ASSERTIONS)
      VM.assertions._assert(VM.objectModel.getObjectEndAddress(to).LE(limit));
  }

  /**
   * Move to the next region, updating the metadata with the current 'write' state.
   */
  void finishAndAdvanceToNextRegion() {
    finish();
    advanceToNextRegion();
  }

  /**
   * Move to the next region, in read-only mode.  Add the assertion of validity,
   * since we shouldn't be able to fall off the end of the list while writing.
   */
  @Override
  void advanceToNextRegion() {
    super.advanceToNextRegion();
    if (VM.VERIFY_ASSERTIONS) VM.assertions._assert(isValid());
  }
}
