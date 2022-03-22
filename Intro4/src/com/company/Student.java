package com.company;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Double.compare(student.grade, grade) == 0 && Objects.equals(name, student.name);
    }
}
