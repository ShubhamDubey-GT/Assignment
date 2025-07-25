package org.assignment;

// Topic: Abstract Class
abstract class Animal {
    String name;

    Animal(String name) {
        this.name = name;
    }
    abstract void sound();

    void sleep() {
        System.out.println(name + " is sleeping.");
    }
}

class Dog extends Animal {
    Dog(String name) {
        super(name);
    }
    void sound() {
        System.out.println(name + " barks.");
    }
}

class Cat extends Animal {
    Cat(String name) {
        super(name);
    }
    void sound() {
        System.out.println(name + " meows.");
    }
}

public class PetHouse {
    public static void main(String[] args) {
        Animal dog = new Dog("Buddy");
        Animal cat = new Cat("Whiskers");

        dog.sound();
        dog.sleep();
        cat.sound();
        cat.sleep();
    }
}
