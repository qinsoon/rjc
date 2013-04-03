package org.mmtk.policy;

import org.mmtk.utility.alloc.BumpPointer;
import org.mmtk.vm.VM;
import org.vmmagic.pragma.Inline;
import org.vmmagic.pragma.Uninterruptible;
import org.vmmagic.unboxed.Address;
import org.vmmagic.unboxed.ObjectReference;

/**
 * Subclass for the read-only cursor that leads the scan of regions.
 */
@Uninterruptible
public final class MarkCompactCollectorFromCursor extends MarkCompactCollectorRegionCursor {
  public MarkCompactCollectorFromCursor() {
    super("from");
  }

  /**
   * Initialize the cursor - the limit is the end of the allocated data
   */
  @Override
  void init(Address region) {
    if (VM.VERIFY_ASSERTIONS) BumpPointer.checkRegionMetadata(region);
    this.region = region;
    this.cursor = MarkCompactLocal.getDataStart(region);
    this.limit = MarkCompactLocal.getDataEnd(region);
  }

  /**
   * Advance from the cursor to the start of the next object.
   * @return The object reference of the next object.
   */
  @Inline
  ObjectReference advanceToObject() {
    ObjectReference current = VM.objectModel.getObjectFromStartAddress(cursor);
    cursor = VM.objectModel.objectStartRef(current);
    if (VM.VERIFY_ASSERTIONS) {
      Address lowBound = BumpPointer.getDataStart(region);
      VM.assertions._assert(cursor.GE(lowBound) && cursor.LE(limit),"Cursor outside region");
    }
    return current;
  }

  /**
   * Advance the cursor to the end of the given object.
   */
  @Inline
  void advanceToObjectEnd(ObjectReference current) {
    cursor = VM.objectModel.getObjectEndAddress(current);
    if (VM.VERIFY_ASSERTIONS) assertCursorInBounds();
  }

  /**
   * Advance the cursor either to the next region in the list,
   * or to a new region allocated from the global list.
   * @param space
   */
  void advanceToNextForwardableRegion(MarkCompactSpace space) {
    if (VM.VERIFY_ASSERTIONS) VM.assertions._assert(get().EQ(getLimit()));
    Address nextRegion = BumpPointer.getNextRegion(region);
    if (nextRegion.isZero()) {
      nextRegion = space.getNextRegion();
      if (nextRegion.isZero()) {
        region = Address.zero();
        return;
      }
      MarkCompactLocal.setNextRegion(region,nextRegion);
      MarkCompactLocal.clearNextRegion(nextRegion);
    }
    init(nextRegion);
    if (VM.VERIFY_ASSERTIONS) assertCursorInBounds();
  }

  /**
   * Override the superclass with an additional assertion - we only advance
   * when we have read to the end, and the cursor must point *precisely*
   * to the last allocated byte in the region.
   */
  @Override
  void advanceToNextRegion() {
    if (VM.VERIFY_ASSERTIONS) VM.assertions._assert(get().EQ(getLimit()));
    super.advanceToNextRegion();
  }

  /**
   * @return {@code true} if there are more objects in this region
   */
  boolean hasMoreObjects() {
    return cursor.LT(limit);
  }
}
