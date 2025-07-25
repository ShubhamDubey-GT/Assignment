package org.assignment3;

class Student {
    private String name;
    private int age;
    private String course;

    // Constructor with multiple parameters
    public Student(String name, int age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }

    // Method to display student details
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Course: " + course);
    }

    // Additional method to update course
    public void updateCourse(String newCourse) {
        this.course = newCourse;
        System.out.println("Course updated to: " + course);
    }
}

public class ClassesAndObjects {
    public static void main(String[] args) {
        Student s1 = new Student("Alice", 20, "Computer Science");
        Student s2 = new Student("Bob", 22, "Mathematics");
        s1.display();
        s2.display();
        s1.updateCourse("Data Science");
        s1.display();
        Student s3 = new Student("Charlie", 21, "Physics");
        s3.display();
        System.out.println("Demonstrating object creation and method calls.");
    }
}
