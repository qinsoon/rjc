package org.rjava.test;

import org.rjava.restriction.rulesets.RJavaCore;

@RJavaCore
public class RJavaThread {
    public static class Loop implements Runnable {
        public void run() {
            System.out.println("start sleeping");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }
            System.out.println("sleeping ends");
        }
        
    }
    
    public static void main(String[] args) {
        Thread t = new Thread(new Loop());
        t.start();
        try {
            t.join(1000);
            System.out.println("joined");
        } catch (InterruptedException e) {
            
        }
    }
}