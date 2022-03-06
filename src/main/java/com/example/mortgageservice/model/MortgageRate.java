package com.example.mortgageservice.model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table
public class MortgageRate {
    @Id
    @Column
    @GeneratedValue
    private Long id;
    @Column
    private Integer maturityPeriod;
    @Column(precision = 5, scale = 4)
    private BigDecimal interestRate;
    @Column
    private Timestamp timeStamp;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMaturityPeriod() {
        return maturityPeriod;
    }

    public void setMaturityPeriod(Integer maturityPeriod) {
        this.maturityPeriod = maturityPeriod;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }
}
