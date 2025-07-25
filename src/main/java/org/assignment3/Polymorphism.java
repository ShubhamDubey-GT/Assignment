package org.assignment3;

class Animal2 {
    void sound() { System.out.println("Some generic animal sound."); }
    public String getType() { return "Animal"; }
}

class Cat extends Animal2 {
    void sound() { System.out.println("Meow"); }
    public String getType() { return "Cat"; }
}

class Cow extends Animal2 {
    void sound() { System.out.println("Moo"); }
    public String getType() { return "Cow"; }
}

public class Polymorphism {
    public static void main(String[] args) {
        Animal2[] animals = new Animal2[3];
        animals[0] = new Cat();
        animals[1] = new Cow();
        animals[2] = new Animal2();
        for (Animal2 a : animals) {
            a.sound();
            System.out.println("Type: " + a.getType());
        }
        System.out.println("Polymorphism with array of objects.");
    }
}
