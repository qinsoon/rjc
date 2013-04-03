package org.mmtk.policy;

import org.vmmagic.pragma.Uninterruptible;
import org.vmmagic.unboxed.ObjectReference;

/**
 * A callback used to perform sweeping of the large object space.
 */
@Uninterruptible
public abstract class LargeObjectSpaceSweeper {
  public abstract boolean sweepLargeObject(ObjectReference object);
}
