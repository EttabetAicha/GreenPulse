package com.example.carbonpersonne.service;

import com.example.carbonpersonne.model.ConsumptionEntry;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ConsumptionService {
    private final List<ConsumptionEntry> consumptionEntries;

    public ConsumptionService() {
        this.consumptionEntries = new ArrayList<>();
    }

    public void addConsumption(Date startDate, Date endDate, double amount) {
        ConsumptionEntry entry = new ConsumptionEntry(startDate, endDate, amount);
        consumptionEntries.add(entry);
    }

    public double calculateTotalConsumption() {
        double total = 0;
        for (ConsumptionEntry entry : consumptionEntries) {
            total += entry.getAmount();
        }
        return total;
    }

    public double calculateDailyConsumption() {
        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -1);
        return calculateConsumptionInRange(cal.getTime(), now);
    }

    public double calculateWeeklyConsumption() {
        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.WEEK_OF_YEAR, -1);
        return calculateConsumptionInRange(cal.getTime(), now);
    }

    public double calculateMonthlyConsumption() {
        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        return calculateConsumptionInRange(cal.getTime(), now);
    }

    private double calculateConsumptionInRange(Date startDate, Date endDate) {
        double total = 0;
        for (ConsumptionEntry entry : consumptionEntries) {
            if (!entry.getEndDate().before(startDate) && !entry.getStartDate().after(endDate)) {
                total += entry.getAmount();
            }
        }
        return total;
    }

    public void displayFootprint() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Carbon Consumption Details:");
        for (ConsumptionEntry entry : consumptionEntries) {
            System.out.println("Start Date: " + sdf.format(entry.getStartDate()) +
                    " - End Date: " + sdf.format(entry.getEndDate()) +
                    " - Carbon Consumed: " + entry.getAmount());
        }
        System.out.println("Total Carbon Footprint: " + calculateTotalConsumption());
    }

    public void displayConsumptionReport() {
        System.out.println("Daily Consumption: " + calculateDailyConsumption());
        System.out.println("Weekly Consumption: " + calculateWeeklyConsumption());
        System.out.println("Monthly Consumption: " + calculateMonthlyConsumption());
    }
}
