package com.example.CarbonPersone.model;

import java.util.Date;

public class ConsumptionEntry {
    private final Date startDate;
    private final Date endDate;
    private final double amount;

    public ConsumptionEntry(Date startDate, Date endDate, double amount) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.amount = amount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public double getAmount() {
        return amount;
    }
}
