package org.rjava.test;

import org.rjava.restriction.rulesets.RJavaCore;

@RJavaCore
public class RJavaMultiarray {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[][] multi_table = new int[2][3];
        for (int i = 0; i < 2; i ++)
            for (int j = 0; j < 3; j++)
                multi_table[i][j] = i * j;
        
        for (int pi = 0; pi < 2; pi ++) {
            for (int pj = 0; pj < 3; pj++) {
                System.out.print(multi_table[pi][pj]);
                System.out.print("|");
            }
            System.out.println();
        }
        
        System.out.println("length:");
        System.out.println(multi_table.length);
        
        int[] multi_table_row1 = multi_table[0];
        
        System.out.println("row 1 length:");
        System.out.println(multi_table_row1.length);
    }

}
