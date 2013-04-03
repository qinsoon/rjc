package org.mmtk.policy;

import org.mmtk.utility.Log;
import org.mmtk.utility.alloc.BumpPointer;
import org.mmtk.vm.VM;
import org.vmmagic.pragma.Inline;
import org.vmmagic.pragma.Uninterruptible;
import org.vmmagic.unboxed.Address;
import org.vmmagic.unboxed.ObjectReference;

/**
 * Both the 'compact' and 'calculate' phases can be thought of as sweeping
 * a pair of cursors across a linked list of regions.  Each cursor requires
 * maintaining pointers to the current region, the current address and the end of
 * the region.  The regionCursor class maintains these 3 pointers, while the
 * subclasses ToCursor and FromCursor provide methods specific to the
 * read and write pointers.
 */
@Uninterruptible
public abstract class MarkCompactCollectorRegionCursor {

  /** Name of the cursor - for debugging messages */
  private final String name;

  /**
   * The current region, or zero if the cursor is invalid (eg after advancing
   * past the end of the current work list
   */
  protected Address region;

  /**
   * The limit of the current region. When reading a populated region, this is the
   * address of the last used byte.  When writing to a fresh region, this is the last
   * byte in the region.
   */
  protected Address limit;

  /** The current address */
  protected Address cursor;

  /**
   * @param name The name of the region - for debugging messages.
   */
  public MarkCompactCollectorRegionCursor(String name) {
    this.name = name;
  }

  /**
   * Hook to allow subclasses to initialize the cursor in different ways.
   *
   * @param region The region to be processed.
   */
  abstract void init(Address region);

  /**
   * Assert that the cursor is within the bounds of the region.  Calls to this
   * must be guarded by {@code if (VM.VERIFY_ASSERTIONS)}
   */
  protected void assertCursorInBounds() {
    VM.assertions._assert(!region.isZero());
    VM.assertions._assert(cursor.GE(BumpPointer.getDataStart(region)),
    "Cursor is below start of region");
    VM.assertions._assert(cursor.LE(limit),"Cursor beyond end of region");
  }

  /**
   * Increment the cursor.
   * @param size Bytes to increment by
   */
  void inc(int size) {
    this.cursor = cursor.plus(size);
    if (VM.VERIFY_ASSERTIONS) assertCursorInBounds();
  }

  /**
   * Increment the cursor to a specific address
   * @param cursor Destination address
   */
  public void incTo(Address cursor) {
    if (VM.VERIFY_ASSERTIONS) assertCursorInBounds();
    if (VM.VERIFY_ASSERTIONS) VM.assertions._assert(cursor.GE(this.cursor));
    this.cursor = cursor;
  }

  /**
   * @param other Other region
   * @return {@code true} if this cursor points to the same region as {@code other}
   */
  boolean sameRegion(MarkCompactCollectorRegionCursor other) {
    return region.EQ(other.getRegion());
  }

  /**
   * @param size Size in bytes
   * @return {@code true} if {@code size} bytes are available in the current region
   */
  boolean isAvailable(int size) {
    return cursor.plus(size).LE(limit);
  }

  /**
   * @return The current cursor
   */
  public Address get() {
    return cursor;
  }

  /**
   * @return The current region pointer
   */
  public Address getRegion() {
    return region;
  }

  /**
   * @return The current region limit
   */
  public Address getLimit() {
    return limit;
  }

  /**
   * Follow the linked-list of regions to the next region.
   */
  void advanceToNextRegion() {
    Address nextRegion = MarkCompactLocal.getNextRegion(region);
    if (nextRegion.isZero()) {
      region = Address.zero();
    } else {
      init(nextRegion);
      if (VM.VERIFY_ASSERTIONS) assertCursorInBounds();
    }
  }

  /**
   * @return {@code true} if we haven't advanced beyond the end of the region list
   */
  boolean isValid() {
    return !region.isZero();
  }

  /**
   * @param ref The object in question
   * @return {@code true} if the object's start address is in this region
   */
  @Inline
  boolean isInRegion(ObjectReference ref) {
    Address addr = VM.objectModel.refToAddress(ref);
    return addr.GE(BumpPointer.getDataStart(region)) && addr.LE(limit);
  }

  /**
   * Print the cursor - for debugging
   */
  void print() {
    Log.write(name); Log.write(" cursor:");
    Log.write(" region="); Log.write(region);
    Log.write(" limit="); Log.write(limit);
    Log.write(" cursor="); Log.write(cursor);
    Log.writeln();

  }
}
