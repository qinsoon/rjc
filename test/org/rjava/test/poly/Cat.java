package org.rjava.test.poly;

public class Cat extends Animal implements DoArithmetic {
    public Cat() {
        this.sound = "Meow";
    }
    
    public void climb(String climbOn) {
        System.out.println("Cat climbs " + climbOn);
    }

    @Override
    public void speak() {
        System.out.println("A cat: " + sound);
    }

    public void calcAdd() {
        System.out.println("1 + 1 = 2");
    }

}
