package org.rjava.test.martins_pl_bench;

import org.rjava.restriction.rulesets.RJavaCore;
import org.vmmagic.unboxed.Address;

@RJavaCore
class IdleTask extends Task {

    IdleTask(int id, int pri, Packet wkq, int state, Address v1, Address v2) {
        super(id, pri, wkq, state, v1, v2);
    }

    Task fn(Packet pkt) {
        Bench.v2 = Bench.v2.minus(1);
        if (Bench.v2.toInt() == 0)
            return (Bench.holdself());

        int x = Bench.v1.toInt();

        if ((x & 1) == 0) {
            Bench.v1 = Address.fromIntZeroExtend(((x >> 1) & Bench.MAXINT));
            return (Bench.release(Bench.I_DEVA));
        } else {
            Bench.v1 = Address.fromIntZeroExtend(((x >> 1) & Bench.MAXINT) ^ 0XD008);
            return (Bench.release(Bench.I_DEVB));
        }
    }
};