package org.rjava.nativeext;

import org.vmmagic.unboxed.Address;
import org.vmmagic.unboxed.Extent;
import org.vmmagic.unboxed.Offset;

public abstract class UnixSysCall {
    // constants for protection and mapping calls
    public static final int PROT_NONE = 0;
    public static final int PROT_READ = 1;
    public static final int PROT_WRITE = 2;
    public static final int PROT_EXEC = 4;

    public static final int MAP_PRIVATE = 2;
    public static final int MAP_FIXED     = 16; 
            //(VM.BuildForLinux) ? 16 : (VM.BuildForOsx) ?     16 : (VM.BuildForSolaris) ? 0x10 :256;
    public static final int MAP_ANONYMOUS = 0x1000; 
            //(VM.BuildForLinux) ? 32 : (VM.BuildForOsx) ? 0x1000 : (VM.BuildForSolaris) ? 0x100 : 16;
    
    public static final int MAP_FAILED = -1;
    
    public static native Address mmap(
            Address start, 
            Extent length, 
            int protection, 
            int flags, 
            int fd, 
            Offset offset);
    
    public static native int mprotect(
            Address start, 
            Extent length, 
            int prot);
}
