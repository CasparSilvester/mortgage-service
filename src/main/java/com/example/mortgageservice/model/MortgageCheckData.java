package com.example.mortgageservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class MortgageCheckData {

    @Id
    @Column
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private BigDecimal income;
    @Column(nullable = false)
    private Integer maturityPeriod;
    @Column(nullable = false)
    private BigDecimal loanValue;
    @Column(nullable = false)
    private BigDecimal homeValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public Integer getMaturityPeriod() {
        return maturityPeriod;
    }

    public void setMaturityPeriod(int maturityPeriod) {
        this.maturityPeriod = maturityPeriod;
    }

    public BigDecimal getLoanValue() {
        return loanValue;
    }

    public void setLoanValue(BigDecimal loanValue) {
        this.loanValue = loanValue;
    }

    public BigDecimal getHomeValue() {
        return homeValue;
    }

    public void setHomeValue(BigDecimal homeValue) {
        this.homeValue = homeValue;
    }
}
