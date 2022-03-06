package com.example.mortgageservice.service;

import com.example.mortgageservice.model.MortgageCheckData;
import com.example.mortgageservice.model.MortgageCheckResult;
import com.example.mortgageservice.repository.MortgageCheckResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

@Service
public class MortgageCheckResultService {

    @Autowired
    private MortgageCheckResultRepository mortgageCheckResultRepository;

    Logger logger = LoggerFactory.getLogger(MortgageCheckResultService.class);

    public MortgageCheckResult validate(MortgageCheckData mortgageCheckData){
        logger.info("validating mortgage");

        //validate according to business rules
        boolean feasible =
                mortgageShouldNotExceed4TimesIncome(mortgageCheckData)&&
                        mortgageShouldNotExceedHomeValue(mortgageCheckData);

        //calculate monthlyCosts
        BigDecimal monthlyCost = calculateMonthlyCost(mortgageCheckData);

        //create new mortgageCheckResult object (with same Id!)
        MortgageCheckResult mortgageCheckResult=new MortgageCheckResult(
                mortgageCheckData.getId(),
                feasible,
                monthlyCost
        );

        //save result
        mortgageCheckResultRepository.save(mortgageCheckResult);

        //return new object with results
        return mortgageCheckResult;
    }


    private boolean mortgageShouldNotExceed4TimesIncome(MortgageCheckData mortgageCheckData){
        //return (mortgageCheckData.getIncome()*4)>mortgageCheckData.getLoanValue();

        int result= mortgageCheckData.getIncome().multiply(new BigDecimal(4)).compareTo(mortgageCheckData.getLoanValue());
        return result > 0;
    }

    private boolean mortgageShouldNotExceedHomeValue(MortgageCheckData mortgageCheckData){
        //return mortgageCheckData.getLoanValue()<mortgageCheckData.getHomeValue();
        int result= mortgageCheckData.getHomeValue().compareTo(mortgageCheckData.getLoanValue());
        return result > 0;
    }

    private BigDecimal calculateMonthlyCost(MortgageCheckData mortgageCheckData){
        //return (BigDecimal)(mortgageCheckData.getLoanValue()/mortgageCheckData.getMaturityPeriod());
        return mortgageCheckData.getLoanValue().divide(new BigDecimal(mortgageCheckData.getMaturityPeriod()));

    }
}
