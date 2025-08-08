package org.assignment7;

import java.util.*;

class StudentComparable implements Comparable<StudentComparable> {
    String name;
    int marks;

    StudentComparable(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public int compareTo(StudentComparable s) {
        return this.marks - s.marks; // Ascending order by marks
    }

    public String toString() {
        return name + ": " + marks;
    }

    public static void main(String[] args) {
        List<StudentComparable> list = new ArrayList<>();
        list.add(new StudentComparable("Aditya", 87));
        list.add(new StudentComparable("Bunty", 92));
        list.add(new StudentComparable("Dhvani", 80));

        Collections.sort(list); // uses compareTo()
        for (StudentComparable s : list) {
            System.out.println(s);
        }
    }
}
