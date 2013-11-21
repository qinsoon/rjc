package testbed;

import org.rjava.restriction.rulesets.RJavaCore;
import org.vmmagic.unboxed.Address;

@RJavaCore
public abstract class Constants {
    public static final Address HEAP_START;
    public static final Address CONTIGUOUS_START;
    public static final Address HEAP_END;
    
    static {
        // we reserved 0x10000000 size for VM
        // so the usable space for client is from HEAP_START + 0x10000000
        if (Configuration.OS == Configuration.MACH_OS && Configuration.BUILD_FOR_64_ADDRESS) {
            HEAP_START          = Address.fromLong(0x7FFF31000000L);
            CONTIGUOUS_START    = Address.fromLong(0x7FFF36800000L);
            HEAP_END            = Address.fromLong(0x7FFF50000000L);
        } else {
            HEAP_START          = Address.fromIntZeroExtend(0x31000000);
            CONTIGUOUS_START    = Address.fromIntZeroExtend(0x36800000);
            HEAP_END            = Address.fromIntZeroExtend(0x70000000);
        }
    }

    /*
     * RJAVA type length
     */
    public static final int INT_IN_BYTES = 4;
    public static final int OBJECTREFERENCE_LENGTH_IN_BYTES = 8;
    public static final int WORD_LENGTH_IN_BYTES = 4;
    /*
     * alignment 
     */
    public static final int LOG_MIN_ALIGNMENT = 0x2;
    public static final int ALIGNMENT_VALUE = 0xdeadbeef;
    /*
     * size constants
     */    
    public static final int LOG_BYTES_IN_BYTE = 0;
    public static final int BYTES_IN_BYTE = 1;
    public static final int LOG_BITS_IN_BYTE = 3;
    public static final int BITS_IN_BYTE = 1 << LOG_BITS_IN_BYTE;

    public static final int LOG_BYTES_IN_BOOLEAN = 0;
    public static final int BYTES_IN_BOOLEAN = 1 << LOG_BYTES_IN_BOOLEAN;
    public static final int LOG_BITS_IN_BOOLEAN = LOG_BITS_IN_BYTE + LOG_BYTES_IN_BOOLEAN;
    public static final int BITS_IN_BOOLEAN = 1 << LOG_BITS_IN_BOOLEAN;

    public static final int LOG_BYTES_IN_CHAR = 1;
    public static final int BYTES_IN_CHAR = 1 << LOG_BYTES_IN_CHAR;
    public static final int LOG_BITS_IN_CHAR = LOG_BITS_IN_BYTE + LOG_BYTES_IN_CHAR;
    public static final int BITS_IN_CHAR = 1 << LOG_BITS_IN_CHAR;

    public static final int LOG_BYTES_IN_SHORT = 1;
    public static final int BYTES_IN_SHORT = 1 << LOG_BYTES_IN_SHORT;
    public static final int LOG_BITS_IN_SHORT = LOG_BITS_IN_BYTE + LOG_BYTES_IN_SHORT;
    public static final int BITS_IN_SHORT = 1 << LOG_BITS_IN_SHORT;

    public static final int LOG_BYTES_IN_INT = 2;
    public static final int BYTES_IN_INT = 1 << LOG_BYTES_IN_INT;
    public static final int LOG_BITS_IN_INT = LOG_BITS_IN_BYTE + LOG_BYTES_IN_INT;
    public static final int BITS_IN_INT = 1 << LOG_BITS_IN_INT;

    public static final int LOG_BYTES_IN_FLOAT = 2;
    public static final int BYTES_IN_FLOAT = 1 << LOG_BYTES_IN_FLOAT;
    public static final int LOG_BITS_IN_FLOAT = LOG_BITS_IN_BYTE + LOG_BYTES_IN_FLOAT;
    public static final int BITS_IN_FLOAT = 1 << LOG_BITS_IN_FLOAT;

    public static final int LOG_BYTES_IN_LONG = 3;
    public static final int BYTES_IN_LONG = 1 << LOG_BYTES_IN_LONG;
    public static final int LOG_BITS_IN_LONG = LOG_BITS_IN_BYTE + LOG_BYTES_IN_LONG;
    public static final int BITS_IN_LONG = 1 << LOG_BITS_IN_LONG;

    public static final int LOG_BYTES_IN_DOUBLE = 3;
    public static final int BYTES_IN_DOUBLE = 1 << LOG_BYTES_IN_DOUBLE;
    public static final int LOG_BITS_IN_DOUBLE = LOG_BITS_IN_BYTE + LOG_BYTES_IN_DOUBLE;
    public static final int BITS_IN_DOUBLE = 1 << LOG_BITS_IN_DOUBLE;

    public static final int LOG_BYTES_IN_ADDRESS = Configuration.BUILD_FOR_64_ADDRESS ? 3 : 2;
    public static final int BYTES_IN_ADDRESS = 1 << LOG_BYTES_IN_ADDRESS;
    public static final int LOG_BITS_IN_ADDRESS = LOG_BITS_IN_BYTE + LOG_BYTES_IN_ADDRESS;
    public static final int BITS_IN_ADDRESS = 1 << LOG_BITS_IN_ADDRESS;

    public static final int LOG_BYTES_IN_WORD = Configuration.BUILD_FOR_64_ADDRESS ? 3 : 2;
    public static final int BYTES_IN_WORD = 1 << LOG_BYTES_IN_WORD;
    public static final int LOG_BITS_IN_WORD = LOG_BITS_IN_BYTE + LOG_BYTES_IN_WORD;
    public static final int BITS_IN_WORD = 1 << LOG_BITS_IN_WORD;

    public static final int LOG_BYTES_IN_EXTENT = Configuration.BUILD_FOR_64_ADDRESS ? 3 : 2;
    public static final int BYTES_IN_EXTENT = 1 << LOG_BYTES_IN_EXTENT;
    public static final int LOG_BITS_IN_EXTENT = LOG_BITS_IN_BYTE + LOG_BYTES_IN_EXTENT;
    public static final int BITS_IN_EXTENT = 1 << LOG_BITS_IN_EXTENT;

    public static final int LOG_BYTES_IN_OFFSET = Configuration.BUILD_FOR_64_ADDRESS ? 3 : 2;
    public static final int BYTES_IN_OFFSET = 1 << LOG_BYTES_IN_OFFSET;
    public static final int LOG_BITS_IN_OFFSET = LOG_BITS_IN_BYTE + LOG_BYTES_IN_OFFSET;
    public static final int BITS_IN_OFFSET = 1 << LOG_BITS_IN_OFFSET;

    public static final int LOG_BYTES_IN_PAGE = 12;
    public static final int BYTES_IN_PAGE = 1 << LOG_BYTES_IN_PAGE;
    public static final int LOG_BITS_IN_PAGE = LOG_BITS_IN_BYTE + LOG_BYTES_IN_PAGE;
    public static final int BITS_IN_PAGE = 1 << LOG_BITS_IN_PAGE;
}
