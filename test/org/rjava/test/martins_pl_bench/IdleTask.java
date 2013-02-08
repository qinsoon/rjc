package org.rjava.test.martins_pl_bench;

import org.rjava.restriction.rulesets.RJavaCore;

@RJavaCore
class IdleTask extends Task {

    IdleTask(int id, int pri, Packet wkq, int state, Object v1, Object v2) {
        super(id, pri, wkq, state, v1, v2);
    }

    Task fn(Packet pkt) {
        int x = ((Integer) Bench.v2).intValue() - 1;
        Bench.v2 = new Integer(x);

        if (x == 0)
            return (Bench.holdself());

        x = ((Integer) Bench.v1).intValue();

        if ((x & 1) == 0) {
            Bench.v1 = new Integer((x >> 1) & Bench.MAXINT);
            return (Bench.release(Bench.I_DEVA));
        } else {
            Bench.v1 = new Integer(((x >> 1) & Bench.MAXINT) ^ 0XD008);
            return (Bench.release(Bench.I_DEVB));
        }
    }
};