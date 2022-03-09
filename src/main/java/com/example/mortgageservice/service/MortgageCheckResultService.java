package com.example.mortgageservice.service;

import com.example.mortgageservice.exception.NoMaturityPeriodFoundException;
import com.example.mortgageservice.model.MortgageCheckData;
import com.example.mortgageservice.model.MortgageCheckResult;
import com.example.mortgageservice.repository.MortgageCheckResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class MortgageCheckResultService {

    @Autowired
    private MortgageCheckResultRepository mortgageCheckResultRepository;
    @Autowired
    private MortgageRateService mortgageRateService;

    Logger logger = LoggerFactory.getLogger(MortgageCheckResultService.class);

    public MortgageCheckResult validate(MortgageCheckData mortgageCheckData) {
        logger.info("validating mortgage");

        //validate according to business rules
        boolean feasible =
                shouldNotContainZeroValues(mortgageCheckData) &&
                        mortgageShouldNotExceed4TimesIncome(mortgageCheckData) &&
                        mortgageShouldNotExceedHomeValue(mortgageCheckData);

        //calculate monthlyCosts
        BigDecimal monthlyCost = calculateMonthlyCost(mortgageCheckData);

        //create new mortgageCheckResult object (with same Id!)
        MortgageCheckResult mortgageCheckResult = new MortgageCheckResult(
                mortgageCheckData.getId(),
                feasible,
                monthlyCost
        );

        //save result
        mortgageCheckResultRepository.save(mortgageCheckResult);

        //return new object with results
        return mortgageCheckResult;
    }


    private boolean mortgageShouldNotExceed4TimesIncome(MortgageCheckData mortgageCheckData) {
        int result = mortgageCheckData.getIncome().multiply(new BigDecimal(4)).compareTo(mortgageCheckData.getLoanValue());
        return result > 0;
    }

    private boolean mortgageShouldNotExceedHomeValue(MortgageCheckData mortgageCheckData) {
        int result = mortgageCheckData.getHomeValue().compareTo(mortgageCheckData.getLoanValue());
        return result > 0;
    }

    //todo: compute benefits: (loanAmount * interestRate)/12
    //      retrieve mortgageRate for certain maturityPeriod
    //      and use it to calculate the monthlyCosts

    private BigDecimal calculateMonthlyCost(MortgageCheckData mortgageCheckData) {
        // if maturityPeriod is zero, we can't calculate valid monthlyCosts
        if (mortgageCheckData.getMaturityPeriod() <= 0) return null;

        //retrieve corresponding interestRate for a certain maturityPeriod
        BigDecimal interestRate;
        try {
            interestRate = mortgageRateService.getInterestRateForMaturityPeriod(mortgageCheckData.getMaturityPeriod());
        } catch (NullPointerException e) {
            throw new NoMaturityPeriodFoundException();
        }
        //return null value when no interestRate can be found for a certain maturityPeriod (although exception occurs first)
        if (interestRate == null) return null;

        //calculate monthlyInterest with formula (yearlyInterest/12=loanAmount*interestRate
        BigDecimal monthlyInterest = (mortgageCheckData.getLoanValue()
                .multiply(interestRate.divide(new BigDecimal(100), 2, RoundingMode.UP))).divide(new BigDecimal(12));
        logger.info("using interestRate of : " + interestRate);

        //calculate monthlyMortgagePayment
        BigDecimal monthlyMortgagePayment = mortgageCheckData.getLoanValue().divide(new BigDecimal(mortgageCheckData.getMaturityPeriod()), 2, RoundingMode.UP);

        //totalMonthlyCosts=  monthlyMortgagePayment + monthlyInterest
        return monthlyMortgagePayment.add(monthlyInterest);

    }

    private boolean shouldNotContainZeroValues(MortgageCheckData mortgageCheckData) {

        return
                (mortgageCheckData.getIncome().compareTo(BigDecimal.ZERO) > 0) &&
                        (mortgageCheckData.getMaturityPeriod() > 0) &&
                        (mortgageCheckData.getLoanValue().compareTo(BigDecimal.ZERO) > 0) &&
                        (mortgageCheckData.getHomeValue().compareTo(BigDecimal.ZERO) > 0);
    }
}
