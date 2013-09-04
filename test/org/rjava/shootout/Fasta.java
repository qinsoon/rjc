package org.rjava.shootout;

import org.rjava.restriction.rulesets.RJavaCore;
import org.vmmagic.pragma.Inline;

/**
 * From C(gcc) on shootout site. But it seems this implementation (including the original one) is buggy
 * @author apple
 *
 */
@Deprecated
@RJavaCore
public class Fasta {
    public static final int IM = 139968;
    public static final int IA = 3877;
    public static final int IC = 29573;
    
    public static long last = 42;
    
    @Inline
    public static double gen_random (double max) {
        return max * (last = (last * IA + IC) % IM) / IM;
    }
    
    static class Aminoacids {
        char c;
        double p;
        
        public Aminoacids (char c, double p) {
            this.c = c;
            this.p = p;
        }
    }
    
    public static void makeCumulative (Aminoacids[] genelist) {
        double cp = 0.0;
        int i;
        
        for (i = 0; i < genelist.length; i++) {
            cp += genelist[i].p;
            genelist[i].p = cp;
        }
    }
    
    public static char selectRandom (Aminoacids[] genelist) {
        double r = gen_random(1);
        int i, lo, hi;
        
        if (r < genelist[0].p)
            return genelist[0].c;
        
        lo = 0;
        hi = genelist.length - 1;
        
        while (hi > lo + 1) {
            i = (hi + lo) / 2;
            if (r < genelist[i].p) 
                hi = i;
            else lo = i;
        }
        return genelist[hi].c;
    }
    
    public static final int LINE_LENGTH = 60;
    
    public static void makeRandomFasta (String id, String desc, Aminoacids[] genelist, int n) {
        int todo = n;
        int i, m;
        
        System.out.println(">" + id + " " + desc);
        
        for (; todo > 0; todo -= LINE_LENGTH) {
            char[] pick = new char[LINE_LENGTH + 1];
            if (todo < LINE_LENGTH) 
                m = todo;
            else m = LINE_LENGTH;
            for (i = 0; i < m; i++)
                pick[i] = selectRandom(genelist);
            pick[m] = '\0';
            System.out.print(pick);
        }
    }
    
    public static void makeRepeatFasta (String id, String desc, String s, int n) {
        char[] ss;
        int todo = n, k = 0, kn = s.length();
        int m;
        
        ss = new String(s).toCharArray();
        
        System.out.println(">" + id + " " + desc);
        
        for (; todo > 0; todo -= LINE_LENGTH) {
            if (todo < LINE_LENGTH)
                m = todo;
            else m = LINE_LENGTH;
            
            while (m >= kn - k) {
                System.out.print(s.substring(k));
                m -= kn - k;
                k = 0;
            }
            
            ss[k + m] = '\0';
            System.out.print(new String(ss).substring(k));
            ss[k + m] = s.charAt(m + k);
            k += m;
        }
    }
    
    public static Aminoacids[] iub = {
        new Aminoacids('a', 0.27),
        new Aminoacids('c', 0.12),
        new Aminoacids('g', 0.12),
        new Aminoacids('t', 0.27),
        
        new Aminoacids('B', 0.02),
        new Aminoacids('D', 0.02),
        new Aminoacids('H', 0.02),
        new Aminoacids('K', 0.02),
        new Aminoacids('M', 0.02),
        new Aminoacids('N', 0.02),
        new Aminoacids('R', 0.02),
        new Aminoacids('S', 0.02),
        new Aminoacids('V', 0.02),
        new Aminoacids('W', 0.02),
        new Aminoacids('Y', 0.02)
    };
    
    public static Aminoacids[] homosapiens = {
        new Aminoacids('a', 0.3029549426680),
        new Aminoacids('c', 0.1979883004921),
        new Aminoacids('g', 0.1975473066391),
        new Aminoacids('t', 0.3015094502008)
    };
    
    public static final String alu = 
            "GGCCGGGCGCGGTGGCTCACGCCTGTAATCCCAGCACTTTGG" +
            "GAGGCCGAGGCGGGCGGATCACCTGAGGTCAGGAGTTCGAGA" +
            "CCAGCCTGGCCAACATGGTGAAACCCCGTCTCTACTAAAAAT" +
            "ACAAAAATTAGCCGGGCGTGGTGGCGCGCGCCTGTAATCCCA" +
            "GCTACTCGGGAGGCTGAGGCAGGAGAATCGCTTGAACCCGGG" +
            "AGGCGGAGGTTGCAGTGAGCCGAGATCGCGCCACTGCACTCC" +
            "AGCCTGGGCGACAGAGCGAGACTCCGTCTCAAAAA";
    
    public static void main(String[] args) {
        int n = 1000;
        if (args.length >= 1)
            n = Integer.parseInt(args[0]);
        
        makeCumulative(iub);
        makeCumulative(homosapiens);
        
        makeRepeatFasta("ONE", "Homo sapiens alu", alu, n*2);
        makeRandomFasta("TWO", "IUB ambiguity codes", iub, n*3);
        makeRandomFasta("THREE", "Homosapiens frequency", homosapiens, n*5);
    }

}
