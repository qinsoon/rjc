package org.rjava.test.martins_pl_bench;

import org.rjava.restriction.rulesets.RJavaCore;
import org.vmmagic.unboxed.Address;
import org.vmmagic.unboxed.ObjectReference;

@RJavaCore
class DevTask extends Task {

    DevTask(int id, int pri, Packet wkq, int state, Address v1, Address v2) {
        super(id, pri, wkq, state, v1, v2);
    }

    Task fn(Packet pkt) {
        if (pkt == null) {
            if (Bench.v1 == null)
                return (Bench.taskwait());
            pkt = (Packet) Bench.v1.toObjectReference().toObject();
            Bench.v1 = null;
            return Bench.qpkt(pkt);
        } else {
            Bench.v1 = ObjectReference.fromObject(pkt).toAddress();
            if (Bench.tracing) {
                // Bench.trace('K');
                Bench.trace((int) pkt.a1);
                // Bench.trace(' ');
            }
            return Bench.holdself();
        }
    }
};