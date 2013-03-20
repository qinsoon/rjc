package org.rjava.test.martins_pl_bench_rjava;

import org.rjava.restriction.rulesets.RJavaCore;
import org.rjava.test.martins_pl_bench_rjava.Task;

@RJavaCore
class Tasktab {
    int upb;
    Task v[];

    public Tasktab(int upb) {
        this.upb = upb;
        this.v = new Task[upb + 1];
    }
}