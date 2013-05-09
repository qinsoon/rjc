package org.rjava.test;

import org.rjava.restriction.rulesets.RJavaCore;

@RJavaCore
public class RJavaMonitor {
    static class Worker implements Runnable {
        static Object o = new Object();
        
        public void run() {
            synchronizedMethod();
        }
        
        public void synchronizedMethod() {
            synchronized (o) {
                System.out.println("synchronized method1 starts");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                }
                System.out.println("synchronized method1 ends");
            }
        }
    }

    public static void main(String[] args) {
        Worker worker = new Worker();
        Thread t1 = new Thread(worker);
        Thread t2 = new Thread(worker);
        t1.start();
        t2.start();
        
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
        }
    }

}
