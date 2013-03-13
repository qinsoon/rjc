package org.rjava.test.martins_pl_bench_rjava;

import org.vmmagic.unboxed.Address;

public class Task {
    Task t_link;
    int t_id;
    int t_pri;
    Packet t_wkq;
    int t_state;
    int t_fn;       // replace function pointer    
    Address t_v1;
    Address t_v2;
    
    public Task t_fn(Packet pkt) {
        switch(t_fn) {
        case Bench.idlefn:      return Bench.idlefn(pkt);
        case Bench.workfn:      return Bench.workfn(pkt);
        case Bench.devfn:       return Bench.devfn(pkt);
        case Bench.handlerfn:   return Bench.handlerfn(pkt);
        default:
            System.out.println("Error in t_fn()");
            return null;
        }
    }
}
