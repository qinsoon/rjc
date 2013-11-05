package org.rjava.osext;

import org.rjava.restriction.rulesets.RJavaCore;
import org.vmmagic.unboxed.Address;
import org.vmmagic.unboxed.Extent;
import org.vmmagic.unboxed.Offset;

@RJavaCore
public abstract class OSMemory {
    public static native Address malloc(int size);
    
    // constants for protection and mapping calls
    public static int PROT_NONE   = 0;
    public static int PROT_READ   = 1;
    public static int PROT_WRITE  = 2;
    public static int PROT_EXEC   = 4;

    /**
     * those constants are defined in org_rjava_osext_OSMemory.h, which is os dependant
     */
    public static int MAP_SHARED;
    public static int MAP_PRIVATE;
    public static int MAP_FIXED; 
            //(VM.BuildForLinux) ? 16 : (VM.BuildForOsx) ?     16 : (VM.BuildForSolaris) ? 0x10 :256;
    public static int MAP_ANONYMOUS; 
            //(VM.BuildForLinux) ? 32 : (VM.BuildForOsx) ? 0x1000 : (VM.BuildForSolaris) ? 0x100 : 16;
    
    public static final int MAP_FAILED = -1;
    
    /**
     * system call: mmap
     * @return RawMemory.MAP_FAILED if fail. Otherwise success 
     */
    public static native Address mmap(
            Address start, 
            Extent length, 
            int protection, 
            int flags, 
            int fd, 
            Offset offset);
    
    /**
     * system call: mprotect
     * @return 0 if success. Otherwise fail 
     */
    public static native int mprotect(
            Address start, 
            Extent length, 
            int prot);
    
    /**
     * system call: memset
     * @return return value equals to start if success. Otherwise fail 
     */
    public static native Address memset(
            Address start,
            int c,
            Extent length);
}
