package org.assignment3;

class Person {
    private String name;
    private int age;
    private String address;

    // Getters and Setters for name
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    // Getters and Setters for age with validation
    public int getAge() { return age; }
    public void setAge(int age) {
        if (age > 0 && age < 120) this.age = age;
        else System.out.println("Invalid age!");
    }

    // Getters and Setters for address
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}

public class Encapsulation {
    public static void main(String[] args) {
        Person p = new Person();
        p.setName("David");
        p.setAge(25);
        p.setAddress("123 Main St");
        System.out.println("Name: " + p.getName());
        System.out.println("Age: " + p.getAge());
        System.out.println("Address: " + p.getAddress());
        p.setAge(-5); // Validation test
        System.out.println("Encapsulation protects data integrity.");
    }
}
