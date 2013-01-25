package org.rjava.test.poly;

public class Animal {
    public void speak() {
        System.out.println("An animal makes noise.");
    }
    
    public static void main(String[] args) {
        // test polymorphism invoke
        Animal animal = new Animal();
        animal.speak();
        
        Animal cat = new Cat();
        cat.speak();
        
        Cat anotherCat = new Cat();
        anotherCat.climb();
    }
}