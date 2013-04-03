package org.mmtk.policy;

import org.vmmagic.pragma.Uninterruptible;
import org.vmmagic.unboxed.ObjectReference;

/**
 * A callback used to perform sweeping of a free list space.
 * This class is used to be defined inside SegregatedFreeListSpace
 */
@Uninterruptible
public abstract class FreeListSpaceSweeper {
  public abstract boolean sweepCell(ObjectReference object);
}

