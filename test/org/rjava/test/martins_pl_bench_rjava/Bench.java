package org.rjava.test.martins_pl_bench_rjava;

import org.rjava.restriction.rulesets.RJavaCore;
import org.vmmagic.unboxed.Address;
import org.vmmagic.unboxed.AddressArray;
import org.vmmagic.unboxed.ObjectReference;

@RJavaCore
public class Bench {
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
    
    static String alphabet = "0ABCDEFGHIJKLMNOPQRSTUVWXYZ";
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
    
    public static final int idlefn = 0;
    public static final int workfn = 1;
    public static final int handlerfn = 2;
    public static final int devfn = 3;
    
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
        
        createtask(I_IDLE, 0, wkq, S_RUN, idlefn, Address.fromLong(1), Address.fromLong(Count));
        
        wkq = pkt(null, 0, K_WORK);
        wkq = pkt(wkq, 0, K_WORK);
        
        createtask(I_WORK, 1000, wkq, S_WAITPKT, workfn, Address.fromLong(I_HANDLERA), Address.fromLong(0));
        
        wkq = pkt(null, I_DEVA, K_DEV);
        wkq = pkt(wkq, I_DEVA, K_DEV);
        wkq = pkt(wkq, I_DEVA, K_DEV);
        
        createtask(I_HANDLERA, 2000, wkq, S_WAITPKT, handlerfn, Address.fromLong(0), Address.fromLong(0));
        
        wkq = pkt(null, I_DEVB, K_DEV);
        wkq = pkt(wkq, I_DEVB, K_DEV);
        wkq = pkt(wkq, I_DEVB, K_DEV);
        
        createtask(I_HANDLERB, 3000, wkq, S_WAITPKT, handlerfn, Address.fromLong(0), Address.fromLong(0));
        
        wkq = null;
        createtask(I_HANDLERB, 4000, wkq, S_WAIT, devfn, Address.fromLong(0), Address.fromLong(0));
        createtask(I_HANDLERB, 5000, wkq, S_WAIT, devfn, Address.fromLong(0), Address.fromLong(0));
        
        tcb = tasklist;
        
        qpktcount = holdcount = 0;
        
        System.out.println("Starting");
        layout = 0;
        
        schedule();
        
        System.out.println("\nfinished");
        
        System.out.println("qpkt count = " + qpktcount + "  holdcount = "
                + holdcount);

        System.out.print("These results are ");
        if (qpktcount == Qpktcountval && holdcount == Holdcountval) {
            System.out.println("correct");
        } else {
            System.out.println("incorrect");
        }

        System.out.println("\nend of run");
    }

    // TODO:
    public static Address append(Packet pkt, Address ptr) {
        System.out.println("append()");
        pkt.p_link = null;
        
        if (ptr.isZero())
            return ObjectReference.fromObject(pkt).toAddress();
        
        Packet p = (Packet) ptr.toObjectReference().toObject();
        Packet q = p;
        while(p.p_link != null) {
            p = p.p_link;
        }
        p.p_link = pkt;
        System.out.println("append() returns");
        return ObjectReference.fromObject(q).toAddress();
    }
    
    public static void createtask(int id, int pri, Packet wkq, int state, int fn, Address v1, Address v2) {
        Task t = new Task();
        tasktab.v[id] = t;
        t.t_link = tasklist;
        t.t_id = id;
        t.t_pri = pri;
        t.t_wkq = wkq;
        t.t_state = state;
        t.t_fn = fn;
        t.t_v1 = v1;
        t.t_v2 = v2;
        tasklist = t;
    }
    
    public static Packet pkt(Packet link, int id, int kind) {
        Packet p = new Packet();
        
        for (int i = 0; i <= BUFSIZE; i++) {
            p.p_a2[i] = '\0';
        }
        
        p.p_link = link;
        p.p_id = id;
        p.p_kind = kind;
        p.p_a1 = 0;
        
        return p;
    }
    
    public static void trace(char a) {
        if (--layout <= 0) {
            System.out.println();
            layout = 50;
        }
        System.out.print(a);
    }
    
    public static void schedule() {
        while (tcb != null) {
            Packet pkt = null;
            Task newtcb;
            
            switch (tcb.t_state) {
            case S_WAITPKT:
                System.out.println("schedule():S_WAITPKT");
                pkt = tcb.t_wkq;
                tcb.t_wkq = pkt.p_link;
                tcb.t_state = (tcb.t_wkq == null? S_RUN : S_RUNPKT);
                
            case S_RUN:
            case S_RUNPKT:
                System.out.println("schedule():S_RUN");
                taskid = tcb.t_id;
                v1 = tcb.t_v1;
                v2 = tcb.t_v2;
                if (tracing) {
                    trace((char)taskid);
                }
                newtcb = tcb.t_fn(pkt);
                tcb.t_v1 = v1;
                tcb.t_v2 = v2;
                tcb = newtcb;
                break;
            
            case S_WAIT:
            case S_HOLD:
            case S_HOLDPKT:
            case S_HOLDWAIT:
            case S_HOLDWAITPKT:
                System.out.println("schedule():S_WAIT");
                tcb = tcb.t_link;
                break;
                
            default:
                return;
            }
        }
    }
    
    public static Task my_wait() {
        System.out.println("my_wait()");
        tcb.t_state |= WAITBIT;
        return tcb;
    }
    
    public static Task holdself() {
        System.out.println("holdself()");
        ++holdcount;
        tcb.t_state |= HOLDBIT;
        return tcb.t_link;
    }
    
    public static Task findtcb(int id) {
        System.out.println("findtcb()");
        Task t = null;
        
        if (1 <= id && id <= tasktab.upb)
            t = tasktab.v[id];
        
        if (t == null) {
            System.out.print("Bad task id ");
            System.out.println(id);
        }
        return t;
    }
    
    public static Task release(int id) {
        System.out.println("release()");
        Task t = findtcb(id);
        if (t == null) return null;
        
        t.t_state &= NOTHOLDBIT;
        if (t.t_pri > tcb.t_pri)
            return t;
        
        return tcb;
    }
    
    public static Task qpkt(Packet pkt) {
        System.out.println("qkt()");
        Task t = findtcb(pkt.p_id);
        if (t == null) return t;
        
        qpktcount++;
        
        pkt.p_link = null;
        pkt.p_id = taskid;
        
        if (t.t_wkq == null) {
            t.t_wkq = pkt;
            t.t_state |= PKTBIT;
            if (t.t_pri > tcb.t_pri)
                return t;
        } else {
            // TODO: 
            Address tmp = append(pkt, ObjectReference.fromObject(t.t_wkq).toAddress());
            t.t_wkq = (Packet) tmp.toObjectReference().toObject();
        }
        
        return tcb;
    }
    
    public static Task idlefn(Packet pkt) {
        System.out.println("idlefn()");
        v2 = v2.minus(1);
        if (v2.toLong() == 0)
            return holdself();
        
        if ((v1.toLong()&1) == 0) {
            v1 = Address.fromLong((v1.toLong() >> 1) & MAXINT);
            return release(I_DEVA);
        } else {
            v1 = Address.fromLong(((v1.toLong()>>1) & MAXINT) ^ 0XD008);
            return release(I_DEVB);
        }
    }
    
    public static Task workfn(Packet pkt) {
        System.out.println("workfn()");
        if (pkt == null)
            return my_wait();
        else {
            v1 = Address.fromLong(I_HANDLERA + I_HANDLERB - v1.toLong());
            pkt.p_id = v1.toInt();
            
            pkt.p_a1 = 0;
            for (int i = 0; i <= BUFSIZE; i++) {
                v2 = v2.plus(1);
                if (v2.toLong() > 26) v2 = Address.fromLong(1L);
                pkt.p_a2[i] = alphabet.charAt(v2.toInt());
            }
        }
        return qpkt(pkt);
    }
    
    public static Task handlerfn(Packet pkt) {
        System.out.println("handlerfn()");
        if (pkt != null)
            // TODO: it seems this line is not well matched with C
            if (pkt.p_kind == K_WORK)
                v1 = append(pkt, v1);
            else v2 = append(pkt, v2);
        
        if (!v1.isZero()) {
            int count;
            Packet workpkt = (Packet) v1.toObjectReference().toObject();
            count  = workpkt.p_a1;
            
            if (count > BUFSIZE) {
                v1 = ObjectReference.fromObject(((Packet)v1.toObjectReference().toObject()).p_link).toAddress();
                return (qpkt(workpkt));
            }
            
            if (!v2.isZero()) {
                Packet devpkt = (Packet) v2.toObjectReference().toObject();
                v2 = ObjectReference.fromObject(((Packet)v1.toObjectReference().toObject()).p_link).toAddress();
                devpkt.p_a1 = workpkt.p_a2[count];
                workpkt.p_a1 = count+1;
                return qpkt(devpkt);
            }
        }
        
        return my_wait();
    }
    
    public static Task devfn(Packet pkt) {
        System.out.println("devfn()");
        if (pkt == null) {
            if (v1.isZero()) return my_wait();
            pkt = (Packet) v1.toObjectReference().toObject();
            v1 = Address.zero();
            return qpkt(pkt);
        } else {
            v1 = ObjectReference.fromObject(pkt).toAddress();
            if (tracing)
                trace((char) pkt.p_a1);
            return holdself();
        }        
    }
}
