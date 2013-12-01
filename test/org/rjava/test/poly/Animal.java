package org.rjava.test.poly;

public class Animal {
    String sound;
    
    public Animal() {
        this.sound = "noissssse";
    }
    
    public void speak() {
        System.out.println("An animal: " + sound);
    }
    
    public static void checkArithmetic(DoArithmetic a) {
        a.calcAdd();
    }
    
    public static void main(String[] args) {
        // test polymorphism invoke
        System.out.println("---Testing method/field override---");
        Animal animal = new Animal();
        animal.speak();
        
        Animal cat = new Cat();
        cat.speak();
        
        Cat anotherCat = new Cat();
        anotherCat.climb("a wall");
        anotherCat.calcAdd();
        
        // test interface invocation
        System.out.println("---Testing interface invocation---");
        checkArithmetic(anotherCat);
        
        DomesticCat domesticCat = new DomesticCat();
        domesticCat.speak();
        domesticCat.climb("a wall");
        domesticCat.calcAdd();
        checkArithmetic(domesticCat);
        
        // test object array
        System.out.println("---Testing object array---");
        Animal[] animals = new Animal[3];
        
        animals[0] = new Animal();
        animals[1] = new Cat();
        animals[2] = new DomesticCat();
        
        for (Animal a : animals) {
            a.speak();
        }
    }
}