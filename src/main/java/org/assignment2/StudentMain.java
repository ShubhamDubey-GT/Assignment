package org.assignment2;

/*
Create a class Student with the following:
 - Variables: name, age
 - A method display() to print student details
 - Create objects and call the method.
 */

class Student {
    String name;
    int age;

    // Constructor
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Display method
    void display() {
        System.out.println("Student Name: " + name);
        System.out.println("Age: " + age);
    }
}

// Test class for Student
public class StudentMain {
    public static void main(String[] args) {
        Student student1 = new Student("Shubham Dubey", 24);
        Student student2 = new Student("Sam Dubey", 19);

        student1.display();
        System.out.println();
        student2.display();
    }
}