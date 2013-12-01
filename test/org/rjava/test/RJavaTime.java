package org.rjava.test;

public class RJavaTime {

    /**
     * @param args
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println("start (millis) = " + start);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("end (millis) = " + end);
        System.out.println("elapse time (roughly 3000 millis) = " + (end - start));
        
        System.out.println();
        
        long startNano = System.nanoTime();
        System.out.println("start (nano) = " + startNano);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endNano = System.nanoTime();
        System.out.println("end (nano) = " + endNano);
        System.out.println("elapse time (roughly 3000 millis) = " + (endNano - startNano));
    }

}
