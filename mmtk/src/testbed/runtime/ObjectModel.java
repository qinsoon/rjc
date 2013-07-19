package testbed.runtime;

import org.rjava.restriction.rulesets.RJavaCore;
import org.vmmagic.unboxed.Address;
import org.vmmagic.unboxed.ObjectReference;
import org.vmmagic.unboxed.Offset;

import testbed.Constants;
import testbed.Main;
import testbed.mminterface.MMTkConstants;

@RJavaCore
public abstract class ObjectModel {
    //                       ->ObjectReference  
    // | GC_HEADER (if needed) | header (WORD) | size (int32_t) | field_count (int32_t) | fields (ObjRefs) ...
    // |                       |    4 bytes    |     4 bytes    |      4 bytes          |    8 bytes       ...
    
    public static final Offset OFFSET_HEADER      = Offset.zero();
    public static final Offset OFFSET_OBJECT_SIZE = Offset.fromIntZeroExtend(4);
    public static final Offset OFFSET_FIELD_COUNT = Offset.fromIntZeroExtend(8);
    public static final Offset OFFSET_FIELD_START = Offset.fromIntZeroExtend(12);
    
    public static final Offset OFFSET_GC_HEADER   = OFFSET_HEADER.minus(MMTkConstants.GC_HEADER_BYTES());
    
    public static final void initializeObject(Address addr, TestbedObject object) {
        // write length
        addr.store(object.getSize(), OFFSET_OBJECT_SIZE);
        
        // write field
        addr.store(object.getFieldCount(), OFFSET_FIELD_COUNT);
        
        Address cursor = addr.plus(OFFSET_FIELD_START);
        for (int i = 0; i < object.fieldCount; i++) {
            cursor.store(object.fields.get(i));
            cursor.plus(Constants.OBJECTREFERENCE_LENGTH_IN_BYTES);
        }            
    }
    
    public static void dumpObject(ObjectReference object) {
        Main.print("Object:");
        Main.print(object);
        Main.println();
        Main.print("  GC HEADER(optional):");
        Main.println(object.toAddress().loadWord(OFFSET_GC_HEADER));
        Main.print("  HEADER:");
        Main.println(object.toAddress().loadWord(OFFSET_HEADER));
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
}
