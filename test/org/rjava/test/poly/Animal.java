package org.rjava.test.poly;

public class Animal {
    String sound;
    
    public Animal() {
        this.sound = "noissssse";
    }
    
    public void speak() {
        System.out.println("An animal: " + sound);
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