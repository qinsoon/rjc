package org.rjava.shootout;

import org.rjava.restriction.rulesets.RJavaCore;
import org.vmmagic.pragma.Inline;
import org.vmmagic.pragma.NoBoundsCheck;

@RJavaCore
public class SpectralNorm {
    @Inline
    public static double eval_A(int i, int j) {
        return 1.0 / ((i + j) * (i + j + 1) / 2 + i + 1);
    }
    
    @NoBoundsCheck
    public static void eval_A_times_u(int N, double[] u, double[] Au) {
        int i, j;
        for (i = 0; i < N; i++) {
            Au[i] = 0;
            for (j = 0; j < N; j++) 
                Au[i] += eval_A(i, j) * u[j];
        }
    }
    
    @NoBoundsCheck
    public static void eval_At_times_u(int N, double[] u, double[] Au) {
        int i, j;
        for (i = 0; i < N; i++) {
            Au[i] = 0;
            for (j = 0; j < N; j++) 
                Au[i] += eval_A(j, i) * u[j];
        }
    }
    
    @NoBoundsCheck
    public static void eval_AtA_times_u(int N, double[] u, double[] AtAu) {
        double[] v = new double[N];
        eval_A_times_u(N, u, v);
        eval_At_times_u(N, v, AtAu);
    }
    
    @NoBoundsCheck
    public static void main(String[] args) {
        int i;
        final int N = (args.length >= 1 ? Integer.parseInt(args[0]) : 2000);
        double[] u = new double[N], v = new double[N];
        double vBv, vv;
        for (i = 0; i < N; i++)
            u[i] = 1;
        for (i = 0; i < 10; i++) {
            eval_AtA_times_u(N, u, v);
            eval_AtA_times_u(N, v, u);
        }
        vBv = vv = 0;
        for (i = 0; i < N; i++) {
            vBv += u[i] * v[i];
            vv += v[i] * v[i];
        }
        System.out.println(Math.sqrt(vBv/vv));
    }

}
