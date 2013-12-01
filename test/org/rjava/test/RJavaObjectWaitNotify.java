package org.rjava.test;

public class RJavaObjectWaitNotify {
    static Object lock = new Object();
    
    static class Waiter implements Runnable {
        public synchronized void run() {
            synchronized (lock) {
                System.out.println("Start waiting...");
                try {
                    lock.wait();
                } catch (InterruptedException ignore) {
                }
                System.out.println("notified");
            }
        }        
    }
    
    static class Notifier implements Runnable {
        public void run() {
            synchronized (lock) {
                System.out.println("Notify in 3 secs");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ignore) {
                }
                lock.notify();
            }
        }        
    }
    public static void main(String[] args) {
        Thread t1 = new Thread(new Waiter());
        Thread t2 = new Thread(new Notifier());
        
        t1.start();
        t2.start();
    }

}
