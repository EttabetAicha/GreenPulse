package com.example.carbonpersonne.model;

import java.util.ArrayList;
import java.util.List;

public class UserEntry {
    private String id;
    private String name;
    private int age;
    private List<ConsumptionEntry> consumption;

    public UserEntry(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.consumption = new ArrayList<>();
    }

    public UserEntry() {
        this.consumption = new ArrayList<>();
    }

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

    public List<ConsumptionEntry> getConsumption() {
        return consumption;
    }

    public void addConsumptionEntry(ConsumptionEntry entry) {
        this.consumption.add(entry);
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age;
    }
}
