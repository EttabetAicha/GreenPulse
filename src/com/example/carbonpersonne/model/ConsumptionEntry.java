package com.example.carbonpersonne.model;

import java.util.Date;

public class ConsumptionEntry {
    private Date startDate;
    private Date endDate;
    private double amount;

    public ConsumptionEntry(Date startDate, Date endDate, double amount) {
        if (endDate.before(startDate)) {
            throw new IllegalArgumentException("End date cannot be before start date.");
        }
        this.startDate = startDate;
        this.endDate = endDate;
        this.amount = amount;
    }

    public ConsumptionEntry() {}

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        if (endDate.before(startDate)) {
            throw new IllegalArgumentException("End date cannot be before start date.");
        }
        this.endDate = endDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public long getDurationInDays() {
        long diffInMillies = Math.abs(endDate.getTime() - startDate.getTime());
        return diffInMillies / (1000 * 60 * 60 * 24);
    }

    @Override
    public String toString() {
        return "ConsumptionEntry{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", amount=" + amount +
                '}';
    }
}
