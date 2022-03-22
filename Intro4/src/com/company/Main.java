package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        // Students Map with TreeSets
        Map<Integer, TreeSet<Student>> studentsByGrade = new HashMap<>();
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student("Alexia", 8.5));
        students.add(new Student("Ionela", 2.95));
        students.add(new Student("Andrei", 3.6));
        students.add(new Student("Tudor", 3.7));
        students.add(new Student("Janica", 6.49));
        students.add(new Student("Toader", 7.21));
        students.add(new Student("Mihnea", 8.12));
        students.add(new Student("Adina", 0.23));
        students.add(new Student("Mirel", 1.4));
        students.add(new Student("Andreea", 1.7));
        students.add(new Student("Rebecca", 9.6));
        students.add(new Student("Alex", 4.5));
        students.add(new Student("Alexandra", 4.6));
        students.add(new Student("Marcel", 0.5));
        students.add(new Student("Mateea", 2.5));
        students.add(new Student("Calin", 10));

        for (int i = 0; i <= 10; ++i) {
            studentsByGrade.put(i, new TreeSet<>());
        }

        for (Student student: students) {
            studentsByGrade.get((int)Math.round(student.getGrade())).add(student);
        }

        for (int i = 0; i <= 10; ++i) {
            System.out.print("Grade " + i + ": ");
            for (Student student: studentsByGrade.get(i))
                System.out.print(student + " ");
            System.out.println();
        }

        MyList<Integer> myIntegersList = new MyList<>(10);
        myIntegersList.add(1);
        myIntegersList.add(2);
        myIntegersList.add(7);
        myIntegersList.print();
        System.out.println("Integer 5 is in list " + myIntegersList.lookup(5));
        System.out.println("Integer 7 is in list " + myIntegersList.lookup(7));

        MyList<Student> myStudentsList = new MyList<>(1);

        for (Student student: students) {
            myStudentsList.add(student);
        }

        myStudentsList.print();
        System.out.println("Student Rebecca is in list " + myStudentsList.lookup(new Student("Rebecca", 9.6)));
        System.out.println("Student Kiki is in list " + myStudentsList.lookup(new Student("Kiki", 7.0)));
    }
}
