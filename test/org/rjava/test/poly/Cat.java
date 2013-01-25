package org.rjava.test.poly;

public class Cat extends Animal {
    public Cat() {
        this.sound = "Meow";
    }
    
    public void climb() {
        System.out.println("Cat climbs trees");
    }

    @Override
    public void speak() {
        System.out.println("A cat: " + sound);
    }

}
