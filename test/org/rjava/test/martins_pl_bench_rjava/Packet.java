package org.rjava.test.martins_pl_bench_rjava;

import org.rjava.restriction.rulesets.RJavaCore;

@RJavaCore
public class Packet {
    Packet p_link;
    int p_id;
    int p_kind;
    int p_a1;
    char[] p_a2 = new char[Bench.BUFSIZE + 1];
}
