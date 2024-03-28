package com.example.idf_test_task.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Rate {

    private String name;

    private BigDecimal value;

    private LocalDate date;

    public Rate() {
    }

    public Rate(String name, BigDecimal value, LocalDate date) {
        this.name = name;
        this.value = value;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
