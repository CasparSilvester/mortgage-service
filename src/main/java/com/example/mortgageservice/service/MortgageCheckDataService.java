package com.example.mortgageservice.service;

import com.example.mortgageservice.exception.IDProvidedException;
import com.example.mortgageservice.model.MortgageCheckData;
import com.example.mortgageservice.model.MortgageCheckResult;
import com.example.mortgageservice.repository.MortgageCheckDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class MortgageCheckDataService {

    @Autowired
    private MortgageCheckDataRepository mortgageCheckDataRepository;
    @Autowired
    private MortgageCheckResultService mortgageCheckResultService;

    Logger logger = LoggerFactory.getLogger(MortgageCheckDataService.class);

    public MortgageCheckResult saveMortgageCheckData(MortgageCheckData mortgageCheckData) {
        logger.info("saving MortgageCheckData-entry");
        if (mortgageCheckData.getId() != null) throw new IDProvidedException();
        mortgageCheckDataRepository.save(mortgageCheckData);
        return mortgageCheckResultService.validate(mortgageCheckData);

    }

}
