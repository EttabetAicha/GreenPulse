package com.example.CarbonPersone.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Consumption {
    private final List<ConsumptionEntry> consumptionEntries;

    public Consumption() {
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

    public void displayFootprint() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Carbon Consumption Details:");
        for (ConsumptionEntry entry : consumptionEntries) {
            System.out.println("Start Date: " + sdf.format(entry.getStartDate()) +
                    " - End Date: " + sdf.format(entry.getEndDate()) +
                    " - Carbon Consumed: " + entry.getAmount() + " kg");
        }
        System.out.println("Total Carbon Footprint: " + calculateTotalConsumption() + " kg");
    }


}
