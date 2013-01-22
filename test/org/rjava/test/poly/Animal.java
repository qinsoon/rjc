package org.rjava.test.poly;

public abstract class Animal {
    abstract void speak();
    
    public static void main(String[] args) {
        // test polymorphism invoke
        Animal cat = new Cat();
        cat.speak();
    }
}
