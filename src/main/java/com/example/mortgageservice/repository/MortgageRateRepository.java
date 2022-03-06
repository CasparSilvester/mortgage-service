package com.example.mortgageservice.repository;

import com.example.mortgageservice.model.MortgageRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MortgageRateRepository  extends JpaRepository<MortgageRate, Long> {
}
