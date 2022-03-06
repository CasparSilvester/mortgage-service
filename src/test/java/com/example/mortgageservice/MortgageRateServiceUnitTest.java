package com.example.mortgageservice;


import com.example.mortgageservice.model.MortgageRate;
import com.example.mortgageservice.service.MortgageRateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class MortgageRateServiceUnitTest {

    @Autowired
    private MortgageRateService mortgageCheckResultService;

    @Test
    public void whenApplicationStarts_thenHibernateCreatesInitialRecords() {
        List<MortgageRate> mortgageRates = mortgageCheckResultService.list();
        System.out.println("testing");
        assertEquals(mortgageRates.size(), 3);
    }
}