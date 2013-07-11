package org.rjava.test.martins_pl_bench;

import org.rjava.restriction.rulesets.RJavaCore;
import org.vmmagic.unboxed.Address;
import org.vmmagic.unboxed.ObjectReference;

@RJavaCore
class HandlerTask extends Task {

    HandlerTask(int id, int pri, Packet wkq, int state, Address v1, Address v2) {
        super(id, pri, wkq, state, v1, v2);
    }

    Task fn(Packet pkt) {
        if (pkt != null) {
            if (pkt.kind == Bench.K_WORK) {
                Bench.v1 = ObjectReference.fromObject(Bench.append(pkt, (Packet) Bench.v1.toObjectReference().toObject())).toAddress();
            } else {
                Bench.v2 = ObjectReference.fromObject(Bench.append(pkt, (Packet) Bench.v2.toObjectReference().toObject())).toAddress();
            }
        }

        if (Bench.v1 != null) {
            Packet workpkt = ((Packet) Bench.v1.toObjectReference().toObject());
            int count = workpkt.a1;
            // System.out.println("Handler: count="+count);
            if (count > Bench.BUFSIZE) {
                Bench.v1 = ObjectReference.fromObject(workpkt.link).toAddress();
                return Bench.qpkt(workpkt);
            }

            if (Bench.v2 != null) {
                Packet devpkt = (Packet) Bench.v2.toObjectReference().toObject();
                Bench.v2 = ObjectReference.fromObject(devpkt.link).toAddress();
                devpkt.a1 = workpkt.a2[count];
                // System.out.println("Handler: setting a1="+devpkt.a1);
                workpkt.a1 = count + 1;
                return Bench.qpkt(devpkt);
            }

        }
        return Bench.taskwait();
    }
};
