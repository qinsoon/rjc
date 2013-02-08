package org.rjava.test.martins_pl_bench;

import org.rjava.restriction.rulesets.RJavaCore;

@RJavaCore
abstract class Task {
    Task link;
    int id;
    int pri;
    Packet wkq;
    int state;
    Object sv1; // Saved values of v1 and v2 which are meant to be like
    Object sv2; // general purpose registers, ie part of the task state.

    Task(int id, int pri, Packet wkq, int state, Object v1, Object v2) {
        this.link = Bench.tasklist;
        this.id = id;
        this.pri = pri;
        this.wkq = wkq;
        this.state = state;
        sv1 = v1;
        sv2 = v2;
        Bench.tasklist = this;
        Bench.tasktab.v[id] = this;
    }

    abstract Task fn(Packet pkt);
};