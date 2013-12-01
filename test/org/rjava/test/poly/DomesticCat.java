package org.rjava.test.poly;

public class DomesticCat extends Cat {
    public DomesticCat() {
        this.sound = "Meow...(domestic)";
    }
    
    public void climb(String climbOn) {
        System.out.println("Domestic cat cannot climb..");
    }
    
    public void calcAdd() {
        System.out.println("1 + 1 = 2; 1 + 2 = 3 (domestic cat is smarter!)");
    }
}
