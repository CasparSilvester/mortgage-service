package com.example.mortgageservice.repository;

import com.example.mortgageservice.model.MortgageCheckResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MortgageCheckResultRepository extends JpaRepository<MortgageCheckResult, Long> {
}
