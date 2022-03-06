package com.example.mortgageservice.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class MortgageCheckResult {
    @Id
    @Column
    private Long id;
    @Column
    private boolean feasible;
    @Column
    private float monthlyCosts;

    public MortgageCheckResult(){}
    public MortgageCheckResult(Long id, boolean feasible, float monthlyCosts){
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

    public float getMonthlyCosts() {
        return monthlyCosts;
    }

    public void setMonthlyCosts(float monthlyCosts) {
        this.monthlyCosts = monthlyCosts;
    }
}
