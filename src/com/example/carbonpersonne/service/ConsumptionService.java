package com.example.carbonpersonne.service;

import com.example.carbonpersonne.model.ConsumptionEntry;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConsumptionService {
    private final List<ConsumptionEntry> consumptionEntries;

    public ConsumptionService() {
        this.consumptionEntries = new ArrayList<>();
    }

    public boolean addConsumption(Date startDate, Date endDate, double amount) {
        if (startDate == null || endDate == null || startDate.after(endDate)) {
            System.out.println("Invalid dates provided. Start date must be before end date.");
            return false;
        }
        if (amount <= 0) {
            System.out.println("Invalid amount provided. Amount must be greater than 0.");
            return false;
        }

        ConsumptionEntry entry = new ConsumptionEntry(startDate, endDate, amount);
        consumptionEntries.add(entry);
        return true;
    }

    public double calculateTotalConsumption() {
        double total = 0;
        for (ConsumptionEntry entry : consumptionEntries) {
            total += entry.getAmount();
        }
        return Math.round(total * 100.0) / 100.0;
    }

    public void displayFootprint() {
        if (consumptionEntries.isEmpty()) {
            System.out.println("No consumption data available.");
            return;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Carbon Consumption Details:");
        System.out.printf("%-15s %-15s %-15s%n", "Start Date", "End Date", "Carbon Consumed");
        System.out.println("--------------------------------------------");

        for (ConsumptionEntry entry : consumptionEntries) {
            System.out.printf("%-15s %-15s %-15.2f%n",
                    sdf.format(entry.getStartDate()),
                    sdf.format(entry.getEndDate()),
                    entry.getAmount());
        }

        System.out.println("--------------------------------------------");
        System.out.printf("Total Carbon Footprint: %.2f%n", calculateTotalConsumption());
    }
}
