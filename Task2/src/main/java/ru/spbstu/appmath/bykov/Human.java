package ru.spbstu.appmath.bykov;

public class Human {
    private String name;
    private int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Human() {
        name = "";
        age = 0;
    }

    String getName(){ return name; }

    int getAge(){ return age; }
}
