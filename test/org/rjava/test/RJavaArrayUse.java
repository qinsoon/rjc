package org.rjava.test;

import org.rjava.restriction.rulesets.RJavaCore;

@RJavaCore
public class RJavaArrayUse {
   
    public static void main(String[] args) {
        char[] intArray = new char[5];
        //Object[] objectArray = new Object[10];
        
        intArray[0] = 'h';
        intArray[1] = 'e';
        intArray[2] = 'l';
        intArray[3] = 'l';
        intArray[4] = 'o';
        printArray(intArray);
        
        intArray[0] = intArray[4];
        printArray(intArray);
    }
    
    public static void printArray(char[] array) {
        for (char i : array) {
            System.out.print(i + ",");
        }
        System.out.println();
    }
}
