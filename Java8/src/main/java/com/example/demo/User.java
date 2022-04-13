package com.example.demo;

import com.thedeanda.lorem.LoremIpsum;

import java.util.Random;

public class User {
    private static int count = 0;
    private static Random rand = new Random();
    private int id;
    private String name;
    private int age;

    private User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public static User createUser() {
        return new User(++count, LoremIpsum.getInstance().getName(), rand.nextInt(101));
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
