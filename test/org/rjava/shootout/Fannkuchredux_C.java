package org.rjava.shootout;

import org.rjava.restriction.rulesets.RJavaCore;
import org.vmmagic.pragma.Inline;

@RJavaCore
public class Fannkuchredux_C {
    
    @Inline
    public static int max(int a, int b) {
        return a > b ? a : b;
    }
    
    public static int fannkuchredux(int n) {
        int[] perm = new int[n];
        int[] perm1 = new int[n];
        int[] count = new int[n];
        int maxFlipsCount = 0;
        int permCount = 0;
        int checksum = 0;
        
        int i;
        
        for (i = 0; i < n; i++)
            perm1[i] = i;
        int r = n;
        
        while(true) {
            while (r != 1) {
                count[r-1] = r;
                r -= 1;
            }
            
            for (i = 0; i < n; i++)
                perm[i] = perm1[i];
            int flipsCount = 0;
            int k;
            
            while (!((k = perm[0]) == 0)) {
                int k2 = (k+1) >> 1;
                for (i = 0; i < k2; i++) {
                    int temp = perm[i];
                    perm[i] = perm[k-i];
                    perm[k-i] = temp;
                }
                flipsCount += 1;
            }
            
            maxFlipsCount = max(maxFlipsCount, flipsCount);
            checksum += permCount % 2 == 0 ? flipsCount : -flipsCount;
            
            while (true) {
                if (r == n) {
                    System.out.println(checksum);
                    return maxFlipsCount;
                }
                
                int perm0 = perm1[0];
                i = 0;
                while(i < r) {
                    int j = i + 1;
                    perm1[i] = perm1[j];
                    i = j;
                }
                perm1[r] = perm0;
                count[r] = count[r] - 1;
                if (count[r] > 0) break;
                r++;
            }
            permCount++;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int n = args.length >= 1 ? Integer.parseInt(args[0]) : 7;
        System.out.print("Pfannkuchen(" + n + ") = ");
        System.out.println(fannkuchredux(n));
    }

}
