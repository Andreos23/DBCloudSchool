package com.company;

public class Student implements Comparable<Student> {
    private final String name;
    private final double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public int compareTo(Student o) {
        return Double.compare(o.grade, grade);
    }

    @Override
    public String toString() {
        return "[" + name + ": " + grade + "]";
    }
}
