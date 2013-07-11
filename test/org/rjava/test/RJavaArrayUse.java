package org.rjava.test;

import org.rjava.restriction.rulesets.RJavaCore;

@RJavaCore
public class RJavaArrayUse {
   
    public static void main(String[] args) {
        int[] intArray = new int[5];
        //Object[] objectArray = new Object[10];
        
        for (int i = 0; i < intArray.length; i++)
            intArray[i] = i;
        printArray(intArray);
        
        intArray[0] = intArray[4];
        printArray(intArray);
    }
    
    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + ",");
        }
        System.out.println();
    }
}
