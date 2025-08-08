package org.assignment7;

import java.util.*;

class StudentComparator {
    String name;
    int marks;

    StudentComparator(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String toString() {
        return name + ": " + marks;
    }

    public static void main(String[] args) {
        List<StudentComparator> list = new ArrayList<>();
        list.add(new StudentComparator("Aditya", 87));
        list.add(new StudentComparator("Bunty", 92));
        list.add(new StudentComparator("Dhvani", 80));

        Collections.sort(list, new SortByName()); // uses compare()
        for (StudentComparator s : list) {
            System.out.println(s);
        }
    }
}

class SortByName implements Comparator<StudentComparator> {
    public int compare(StudentComparator a, StudentComparator b) {
        return a.name.compareTo(b.name);
    }
}
