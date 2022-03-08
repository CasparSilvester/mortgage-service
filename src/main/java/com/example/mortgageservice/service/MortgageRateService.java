package com.example.mortgageservice.service;

import com.example.mortgageservice.model.MortgageRate;
import com.example.mortgageservice.repository.MortgageRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class MortgageRateService {
    @Autowired
    MortgageRateRepository mortgageRateRepository;

    public List<MortgageRate> list() {
        return mortgageRateRepository.findAll();
    }

    public BigDecimal getInterestRateForMaturityPeriod(Integer maturityPeriod){
        return mortgageRateRepository.findByMaturityPeriod(maturityPeriod).getInterestRate();
    }
}
