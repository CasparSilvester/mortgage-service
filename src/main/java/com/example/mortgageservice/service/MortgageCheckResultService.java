package com.example.mortgageservice.service;

import com.example.mortgageservice.model.MortgageCheckData;
import com.example.mortgageservice.model.MortgageCheckResult;
import com.example.mortgageservice.repository.MortgageCheckResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MortgageCheckResultService {

    @Autowired
    private MortgageCheckResultRepository mortgageCheckResultRepository;

    public MortgageCheckResult validate(MortgageCheckData mortgageCheckData){
        //validate according to business rules
        boolean feasible =
                mortgageShouldNotExceed4TimesIncome(mortgageCheckData)&&
                        mortgageShouldNotExceedHomeValue(mortgageCheckData);

        //calculate monthlyCosts
        float monthlyCost = calculateMonthlyCost(mortgageCheckData);

        //create new mortgageCheckResult object (with same Id!)
        MortgageCheckResult mortgageCheckResult=new MortgageCheckResult(
                mortgageCheckData.getId(),
                feasible, monthlyCost
        );

        //save result
        mortgageCheckResultRepository.save(mortgageCheckResult);

        //return new object with results
        return mortgageCheckResult;
    }


    private boolean mortgageShouldNotExceed4TimesIncome(MortgageCheckData mortgageCheckData){
        return true;
    }

    private boolean mortgageShouldNotExceedHomeValue(MortgageCheckData mortgageCheckData){
        return true;
    }

    private float calculateMonthlyCost(MortgageCheckData mortgageCheckData){
        return (float)(mortgageCheckData.getLoanValue()/mortgageCheckData.getMaturityPeriod());
    }
}
