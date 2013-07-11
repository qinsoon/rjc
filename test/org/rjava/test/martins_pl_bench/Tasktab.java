package org.rjava.test.martins_pl_bench;

import org.rjava.restriction.rulesets.RJavaCore;

@RJavaCore
class Tasktab {
    int upb;
    Task v[];

    public Tasktab(int upb) {
        this.upb = upb;
        this.v = new Task[upb + 1];
    }
}
