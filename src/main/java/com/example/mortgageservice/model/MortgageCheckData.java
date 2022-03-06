package com.example.mortgageservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MortgageCheckData {

    @Id
    @Column
    @GeneratedValue
    private Long id;
    @Column
    private float income;
    @Column
    private int maturityPeriod;
    @Column
    private float loanValue;
    @Column
    private float homeValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public int getMaturityPeriod() {
        return maturityPeriod;
    }

    public void setMaturityPeriod(int maturityPeriod) {
        this.maturityPeriod = maturityPeriod;
    }

    public float getLoanValue() {
        return loanValue;
    }

    public void setLoanValue(float loanValue) {
        this.loanValue = loanValue;
    }

    public float getHomeValue() {
        return homeValue;
    }

    public void setHomeValue(float homeValue) {
        this.homeValue = homeValue;
    }
}
