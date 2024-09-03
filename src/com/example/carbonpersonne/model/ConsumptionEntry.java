package com.example.carbonpersonne.model;

import java.util.Date;

public class ConsumptionEntry {
    private  Date startDate;
    private  Date endDate;
    private  double amount;

    public ConsumptionEntry(Date startDate, Date endDate, double amount) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.amount = amount;
    }
    public ConsumptionEntry(){

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
