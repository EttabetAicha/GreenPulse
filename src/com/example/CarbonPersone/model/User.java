package com.example.CarbonPersone.model;

public class User {
    private  String id;
    private String name;
    private int age;
    private  Consumption consumption;

    public User(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.consumption = new Consumption();
    }
    public User(){}

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Consumption getConsumption() {
        return consumption;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age;
    }
}
