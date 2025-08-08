package org.assignment9;

class Address {
    String city;
    Address(String city) {
        this.city = city;
    }
}

class Student implements Cloneable {
    String name;
    Address address;

    Student(String name, Address address) {
        this.name = name;
        this.address = address;
    }

//    public Object clone() throws CloneNotSupportedException {
//        return super.clone(); // shallow copy is being used here which copies reference of actual object.
//    }

    public Object clone() throws CloneNotSupportedException {
        Student s = (Student) super.clone();
        s.address = new Address(this.address.city); // deep copy of nested object which makes completely new copy
        return s;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Address addr = new Address("Delhi");
        Student s1 = new Student("Ravi", addr);
        Student s2 = (Student) s1.clone();

        s2.name = "Amit";
        s2.address.city = "Mumbai"; // Affects s1 too (shallow copy)

        System.out.println(s1.name + " - " + s1.address.city); // Ravi - Mumbai
        System.out.println(s2.name + " - " + s2.address.city); // Amit - Mumbai
    }
}

