package com.example.mortgageservice.repository;

import com.example.mortgageservice.model.MortgageCheckData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MortgageCheckDataRepository extends JpaRepository<MortgageCheckData, Long> {
}
