package org.rjava.test.poly;

public class Cat extends Animal {
    
    public void climb() {
        System.out.println("Cat climbs trees");
    }

    @Override
    public void speak() {
        System.out.println("Meow!!");
    }

}
