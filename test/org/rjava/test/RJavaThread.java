package org.rjava.test;

public class RJavaThread {
    public static class Loop implements Runnable {
        public void run() {
            System.out.println("start loop");
        }
        
    }
    
    public static void main(String[] args) {
        Thread t = new Thread(new Loop());
        t.start();
    }
}