package com.example.mortgageservice.service;

import com.example.mortgageservice.model.MortgageCheckData;
import com.example.mortgageservice.model.MortgageCheckResult;
import com.example.mortgageservice.repository.MortgageCheckDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MortgageCheckDataService {

    @Autowired
    private MortgageCheckDataRepository mortgageCheckDataRepository;
    @Autowired
    private MortgageCheckResultService mortgageCheckResultService;

    public MortgageCheckResult saveMortgageCheckData(MortgageCheckData mortgageCheckData){
        mortgageCheckDataRepository.save(mortgageCheckData);
        return mortgageCheckResultService.validate(mortgageCheckData);
    }

}
