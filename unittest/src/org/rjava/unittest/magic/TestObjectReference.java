package org.rjava.unittest.magic;

import org.rjava.restriction.rulesets.RJavaCore;
import org.rjava.unittest.UnitTest;
import org.vmmagic.unboxed.Address;
import org.vmmagic.unboxed.ObjectReference;

@RJavaCore
public class TestObjectReference extends UnitTest{

    public static void main(String[] args) {
        start("ObjectReference fromObject/toObject");
        check(TestObjectReferenceFromObjectToObject());
        
        start("ObjectReference toAddress");
        check(TestObjectReferenceToAddress());
        
        start("ObjectReference isNull");
        check(TestObjectReferenceIsNull());
    }

    public static boolean TestObjectReferenceFromObjectToObject() {
        Integer i = new Integer(99);
        
        ObjectReference ref = ObjectReference.fromObject(i);
        Integer i2 = (Integer) ref.toObject();
        
        return i2 == 99;
    }
    
    public static boolean TestObjectReferenceToAddress() {
        Integer i = new Integer(99);
        
        ObjectReference ref = ObjectReference.fromObject(i);
        Address addr = ref.toAddress();
        Integer i2 = (Integer) addr.toObjectReference().toObject();
        
        return i2 == 99;
    }
    
    public static boolean TestObjectReferenceIsNull() {
        Integer i = null;
        ObjectReference ref = ObjectReference.fromObject(i);
        ObjectReference nullRef = ObjectReference.nullReference();
        
        return ref.isNull() && ref.toAddress().EQ(nullRef.toAddress());
    }
}
