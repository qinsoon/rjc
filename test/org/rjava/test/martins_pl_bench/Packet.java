package org.rjava.test.martins_pl_bench;

import org.rjava.restriction.rulesets.RJavaCore;

@RJavaCore
class Packet {
    Packet link;
    int id;
    int kind;
    int a1;
    int[] a2;

    public Packet(Packet link, int id, int kind) {
        this.link = link;
        this.id = id;
        this.kind = kind;
        a2 = new int[Bench.BUFSIZE + 1];
        for (int i = 0; i < Bench.BUFSIZE; i++)
            a2[i] = 0;
    }
};