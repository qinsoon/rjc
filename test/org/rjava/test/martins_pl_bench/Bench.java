package org.rjava.test.martins_pl_bench;

/*

 **  This is a Java version of the systems programming language benchmark.
 **  It uses very few object oriented features of the language.

 **  Implemented by M. Richards, based on the C version by M.J. Jordan.

 **  17/07/2007 Initial version
 **
 **  To run this benchmark, type:
 **
 **  make run
 **
 **  or
 **
 **  make run100
 **
 */

import java.io.*;
import java.lang.*;

import org.rjava.restriction.rulesets.RJavaCore;
import org.vmmagic.unboxed.Address;

@RJavaCore
public class Bench {
    static int count = 0;

    static int Count = 10000;
    static int Qpktcountval = 23246;
    static int Holdcountval = 9297;

    static int Count100 = 10000 * 100;
    static int Qpktcountval100 = 2326410;
    static int Holdcountval100 = 930563;

    final static int MAXINT = 32767;

    final static int BUFSIZE = 3;
    final static int I_IDLE = 1;
    final static int I_WORK = 2;
    final static int I_HANDLERA = 3;
    final static int I_HANDLERB = 4;
    final static int I_DEVA = 5;
    final static int I_DEVB = 6;
    final static int PKTBIT = 1;
    final static int WAITBIT = 2;
    final static int HOLDBIT = 4;
    final static int NOTPKTBIT = ~1;
    final static int NOTWAITBIT = ~2;
    final static int NOTHOLDBIT = 0xFFFB;

    final static int S_RUN = 0;
    final static int S_RUNPKT = 1;
    final static int S_WAIT = 2;
    final static int S_WAITPKT = 3;
    final static int S_HOLD = 4;
    final static int S_HOLDPKT = 5;
    final static int S_HOLDWAIT = 6;
    final static int S_HOLDWAITPKT = 7;

    final static int K_DEV = 1000;
    final static int K_WORK = 1001;

    static String alphabet = "#ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static Tasktab tasktab = new Tasktab(11);

    static Task tasklist = null;
    static Task tcb;
    static int taskid;
    static Address v1; // These are meant to be like CPU registers, ie
    static Address v2; // saved as part of the task state.
    static int qpktcount = 0;
    static int holdcount = 0;
    static boolean tracing = false;
    static int layout = 0;

    public static void main(String[] args) {
        tracing = false;
        for (int i = 0; i < args.length; i++) {

            if (args[i].equals("-100")) {
                Count = Count100;
                Qpktcountval = Qpktcountval100;
                Holdcountval = Holdcountval100;
                continue;
            }

            if (args[i].equals("-t")) {
                tracing = true;
                continue;
            }
        }

        Packet wkq = null;

        System.out.println("Bench mark starting");

        new IdleTask(I_IDLE, 0, wkq, S_RUN, Address.fromIntZeroExtend(1), Address.fromIntZeroExtend(Count));

        wkq = new Packet(null, 0, K_WORK);
        wkq = new Packet(wkq, 0, K_WORK);

        new WorkTask(I_WORK, 1000, wkq, S_WAITPKT, Address.fromIntZeroExtend(I_HANDLERA), Address.zero());

        wkq = new Packet(null, I_DEVA, K_DEV);
        wkq = new Packet(wkq, I_DEVA, K_DEV);
        wkq = new Packet(wkq, I_DEVA, K_DEV);

        new HandlerTask(I_HANDLERA, 2000, wkq, S_WAITPKT, Address.zero(), Address.zero());

        wkq = new Packet(null, I_DEVB, K_DEV);
        wkq = new Packet(wkq, I_DEVB, K_DEV);
        wkq = new Packet(wkq, I_DEVB, K_DEV);

        new HandlerTask(I_HANDLERB, 3000, wkq, S_WAITPKT, Address.zero(), Address.zero());

        wkq = null;
        new DevTask(I_DEVA, 4000, wkq, S_WAIT, Address.zero(), Address.zero());
        new DevTask(I_DEVB, 5000, wkq, S_WAIT, Address.zero(), Address.zero());

        tcb = tasklist;

        qpktcount = holdcount = 0;

        System.out.println("Starting");

        layout = 0;

        schedule();

        System.out.println("\nfinished\n");

        System.out.println("qpkt count = " + qpktcount + "  holdcount = "
                + holdcount);

        System.out.print("These results are ");
        if (qpktcount == Qpktcountval && holdcount == Holdcountval) {
            System.out.println("correct");
        } else {
            System.out.println("incorrect");
        }

        System.out.println("end of run");
    }

    static void schedule() {
        while (tcb != null) {
            Packet pkt = null;
            Task newtcb;

            // System.out.println("Task "+tcb.id+" state="+tcb.state);

            switch (tcb.state) {
            case S_WAITPKT:
                pkt = tcb.wkq;
                tcb.wkq = pkt.link;
                tcb.state = (tcb.wkq == null) ? S_RUN : S_RUNPKT;

            case S_RUN:
            case S_RUNPKT:
                taskid = tcb.id;
                v1 = tcb.sv1;
                v2 = tcb.sv2;
                if (tracing) {
                    // trace('T');
                    trace(taskid + '0');
                    // trace(' ');
                }
                newtcb = tcb.fn(pkt);
                tcb.sv1 = v1;
                tcb.sv2 = v2;
                tcb = newtcb;
                // System.out.println("schedule: newtcb.id="+tcb.id);
                break;

            case S_WAIT:
            case S_HOLD:
            case S_HOLDPKT:
            case S_HOLDWAIT:
            case S_HOLDWAITPKT:
                tcb = tcb.link;
                break;

            default:
                return;
            }
        }
    }

    public static void trace(int a) {
        if (--layout <= 0) {
            System.out.println("");
            layout = 50;
        }

        System.out.print((char) a);
    }

    public static Task release(int id) {
        Task t;

        t = findtcb(id);
        if (t == null)
            return null;

        t.state &= NOTHOLDBIT;
        if (t.pri > tcb.pri)
            return t;

        return tcb;
    }

    public static Task taskwait() {
        tcb.state |= WAITBIT;
        return tcb;
    }

    public static Task holdself() {
        ++holdcount;
        tcb.state |= HOLDBIT;
        return tcb.link;
    }

    static Task findtcb(int id) {
        Task t = null;

        if (1 <= id && id <= tasktab.upb)
            t = tasktab.v[id];
        if (t == null)
            System.out.println("\nBad task id " + id);
        return t;
    }

    public static Task qpkt(Packet pkt) {
        Task t = findtcb(pkt.id);

        if (t == null)
            return null;

        qpktcount++;

        // System.out.println("qpkt: sending pkt from T"+taskid+" to T"+pkt.id);
        pkt.link = null;
        pkt.id = taskid;

        if (t.wkq == null) {
            t.wkq = pkt;
            t.state |= PKTBIT;
            // System.out.println("qpkt: dest pri = "+t.pri+" curr pri = "+tcb.pri);
            if (t.pri > tcb.pri)
                return t;
        } else {
            t.wkq = append(pkt, t.wkq);
        }

        return tcb;
    }

    public static Packet append(Packet pkt, Packet p) {
        pkt.link = null;

        if (p == null)
            return pkt;

        Packet q = p;
        while (p.link != null)
            p = p.link;

        p.link = pkt;

        return q;
    }
}
