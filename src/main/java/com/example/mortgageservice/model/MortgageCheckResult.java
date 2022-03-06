package com.example.mortgageservice.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table
public class MortgageCheckResult {
    @Id
    @Column
    private Long id;
    @Column
    private Boolean feasible;
    @Column
    private BigDecimal monthlyCosts;

    public MortgageCheckResult(){}
    public MortgageCheckResult(Long id, boolean feasible, BigDecimal monthlyCosts){
        this.id=id;
        this.feasible=feasible;
        this.monthlyCosts=monthlyCosts;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isFeasible() {
        return feasible;
    }

    public void setFeasible(boolean feasible) {
        this.feasible = feasible;
    }

    public BigDecimal getMonthlyCosts() {
        return monthlyCosts;
    }

    public void setMonthlyCosts(BigDecimal monthlyCosts) {
        this.monthlyCosts = monthlyCosts;
    }
}
