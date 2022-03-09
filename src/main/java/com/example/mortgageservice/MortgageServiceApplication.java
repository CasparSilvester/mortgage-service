package com.example.mortgageservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.mortgageservice", "com.example.controller"})
public class MortgageServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MortgageServiceApplication.class, args);
    }

}
