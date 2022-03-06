package com.example.mortgageservice.model;

import javax.persistence.*;

@Entity
@Table
public class MortgageRate {
    @Id
    @Column
    @GeneratedValue
    private Long id;
    @Column
    private int maturityPeriod;
    @Column
    private float interestRate;
    @Column
    private String timeStamp;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMaturityPeriod() {
        return maturityPeriod;
    }

    public void setMaturityPeriod(int maturityPeriod) {
        this.maturityPeriod = maturityPeriod;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
