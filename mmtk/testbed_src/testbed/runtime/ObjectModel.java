package testbed.runtime;

import org.rjava.restriction.rulesets.RJavaCore;
import org.vmmagic.pragma.Inline;
import org.vmmagic.unboxed.Address;
import org.vmmagic.unboxed.ObjectReference;
import org.vmmagic.unboxed.Offset;
import org.vmmagic.unboxed.Word;

import testbed.Constants;
import testbed.Main;
import testbed.mminterface.MMTkConstants;

@RJavaCore
public abstract class ObjectModel {
    //                       ->ObjectReference  
    // | GC_HEADER (if needed) | header (WORD) | cl_header (WORD) | size (int32_t) | field_count (int32_t) | fields (ObjRefs) ...
    // |                       |    4 bytes    |     4 bytes      |     4 bytes    |      4 bytes          |    8 bytes       ...
    
    public static final Offset OFFSET_HEADER        = Offset.zero();
    public static final Offset OFFSET_CLIENT_HEADER = Offset.fromIntZeroExtend(4);
    public static final Offset OFFSET_OBJECT_SIZE   = Offset.fromIntZeroExtend(8);
    public static final Offset OFFSET_FIELD_COUNT   = Offset.fromIntZeroExtend(12);
    public static final Offset OFFSET_FIELD_START   = Offset.fromIntZeroExtend(16);
    
    public static final Offset OFFSET_GC_HEADER     = OFFSET_HEADER.minus(MMTkConstants.GC_HEADER_BYTES());
    
    @Inline
    public static final void initializeObject(ObjectReference objRef, TestbedObject object) {
        Address addr = objRef.toAddress();
        
        // write client header
        addr.store(Word.zero(), OFFSET_CLIENT_HEADER);
        
        // write length
        addr.store(object.getSize(), OFFSET_OBJECT_SIZE);
        
        // write field
        addr.store(object.getFieldCount(), OFFSET_FIELD_COUNT);
        
        Address cursor = addr.plus(OFFSET_FIELD_START);
        for (int i = 0; i < object.getFieldCount(); i++) {
            cursor.store(object.getField(i));
            cursor = cursor.plus(Constants.OBJECTREFERENCE_LENGTH_IN_BYTES);
        }            
    }
    
    public static void initializeCopiedObject(ObjectReference fromObj, ObjectReference toObj) {
        Address from = fromObj.toAddress();
        Address to = toObj.toAddress();
        
        to.store(from.loadWord(OFFSET_CLIENT_HEADER), OFFSET_CLIENT_HEADER);
        to.store(from.loadInt(OFFSET_OBJECT_SIZE), OFFSET_OBJECT_SIZE);
        int fieldCount = from.loadInt(OFFSET_FIELD_COUNT);
        to.store(fieldCount, OFFSET_FIELD_COUNT);
        
        Address fromCursor = from.plus(OFFSET_FIELD_START);
        Address toCursor = to.plus(OFFSET_FIELD_START);
        for (int i = 0; i < fieldCount; i++) {
            toCursor.store(fromCursor.loadObjectReference());
            toCursor = toCursor.plus(Constants.OBJECTREFERENCE_LENGTH_IN_BYTES);
            fromCursor = fromCursor.plus(Constants.OBJECTREFERENCE_LENGTH_IN_BYTES);
        }
    }
    
    public static final void writeClientHeader(ObjectReference obj, int header) {
        obj.toAddress().store(header, OFFSET_CLIENT_HEADER);
    }
    
    public static final int readClientHeader(ObjectReference obj) {
        return obj.toAddress().loadInt(OFFSET_CLIENT_HEADER);
    }
    
    public static int objectMinSize() {
        return testbed.Constants.WORD_LENGTH_IN_BYTES * 2+ // header + client header
                testbed.Constants.INT_IN_BYTES + // size
                testbed.Constants.INT_IN_BYTES;// field count
    }
    
    public static void dumpObject(ObjectReference object) {
        Main.print("Object:");
        Main.print(object);
        Main.println();
        Main.print("  GC HEADER(optional):");
        Main.println(object.toAddress().loadWord(OFFSET_GC_HEADER));
        Main.print("  HEADER:");
        Main.println(object.toAddress().loadWord(OFFSET_HEADER));
        Main.print("  CLIENT HEADER:");
        Main.println(object.toAddress().loadWord(OFFSET_CLIENT_HEADER));
        Main.print("  LENGTH:");
        Main.println(object.toAddress().loadInt(OFFSET_OBJECT_SIZE));
        Main.print("  FIELDS:(");
        int fieldCount = object.toAddress().loadInt(OFFSET_FIELD_COUNT);
        Main.print(fieldCount); Main.println(")");
        Address cursor = object.toAddress().plus(OFFSET_FIELD_START);
        for (int i = 0; i < fieldCount; i++) {
            Main.print("   -field");
            Main.print(i);
            Main.print(":");
            Main.println(cursor.loadObjectReference());
            cursor = cursor.plus(Constants.OBJECTREFERENCE_LENGTH_IN_BYTES);
        }
    }
    
    public static int bytesRequiredWhenCopied(ObjectReference objRef) {
        Address addr = objRef.toAddress();
        return addr.loadInt(OFFSET_OBJECT_SIZE);
    }
    
    /*
     * for debug use
     */
    public static final int ROOT_MASK = 0x1;
    public static final int REFERENCED_MASK = 0x10;
}
