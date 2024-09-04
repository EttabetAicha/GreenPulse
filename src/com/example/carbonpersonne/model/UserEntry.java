package com.example.carbonpersonne.model;

import com.example.carbonpersonne.service.ConsumptionService;

import java.util.Date;

public class UserEntry {
    private String id;
    private String name;
    private int age;
    private final ConsumptionService consumptionService;

    public UserEntry(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.consumptionService = new ConsumptionService();
    }

    public UserEntry() {
        this.consumptionService = new ConsumptionService();
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

    public ConsumptionService getConsumptionService() {
        return consumptionService;
    }

    public void addConsumptionEntry(Date startDate, Date endDate, double amount) {
        this.consumptionService.addConsumption(startDate, endDate, amount);
    }

    public void displayFootprint() {
        this.consumptionService.displayFootprint();
    }

    public void displayConsumptionReport() {
        this.consumptionService.displayConsumptionReport();
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age;
    }
}
