package org.assignment3;

class Animal {
    protected String type;
    void eat() { System.out.println("This animal eats food."); }
    public Animal() { type = "Unknown"; }
}

class Dog extends Animal {
    private String breed;
    void bark() { System.out.println("The dog barks."); }
    void eat() { System.out.println("Dog eats bones."); }
    public Dog(String breed) { this.breed = breed; type = "Dog"; }
}

class Puppy extends Dog {
    void play() { System.out.println("Puppy is playing."); }
    public Puppy(String breed) { super(breed); }
}

public class Inheritance {
    public static void main(String[] args) {
        Dog d = new Dog("Labrador");
        d.eat();
        d.bark();
        Puppy p = new Puppy("Golden");
        p.eat();
        p.play();
        System.out.println("Multi-level inheritance demonstrated.");
    }
}
