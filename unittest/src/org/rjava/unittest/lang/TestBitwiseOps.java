package org.rjava.unittest.lang;

import org.rjava.unittest.UnitTest;

public class TestBitwiseOps extends UnitTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        start("Test bit and");
        check(testBitAnd());
        
        start("Test bit or");
        check(testBitOr());
        
        start("Test bit xor");
        check(testBitXor());
        
        start("Test bit signed shift right");
        check(testBitSignedShiftRight());
        
        start("Test bit unsigned shift right");
        check(testBitUnsignedShiftRight());
        
        start("Test bit shift left");
        check(testBitShiftLeft());
    }

    public static boolean testBitAnd() {
        int a       = 0x10101010;
        int mask    = 0xffff0000;
        
        return (a & mask) == 0x10100000;
    }
    
    public static boolean testBitOr() {
        int a       = 0x10101010;
        int mask    = 0xffff0000;
        
        return (a | mask) == 0xffff1010;
    }
    
    public static boolean testBitXor() {
        int a       = 0x10101010;
        int mask    = 0xffff0000;
        return (a ^ mask) == 0xefef1010;
    }
    
    public static boolean testBitSignedShiftRight() {
        int a       = 0xf0101010;
        return (a >> 8) == 0xfff01010;
    }
    
    public static boolean testBitUnsignedShiftRight() {
        int a       = 0x10101010;
        return (a >>> 8) == 0x00101010;
    }
    
    public static boolean testBitShiftLeft() {
        int a       = 0x10101010;
        return (a << 8) == 0x10101000;
    }
}
