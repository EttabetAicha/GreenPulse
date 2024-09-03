package com.example.carbonpersonne.model;

import com.example.carbonpersonne.service.ConsumptionService;

public class UserEntry {
    private  String id;
    private String name;
    private int age;
    private ConsumptionService consumption;

    public UserEntry(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.consumption = new ConsumptionService();
    }
    public UserEntry(){}

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

    public ConsumptionService getConsumption() {
        return consumption;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age;
    }
}
