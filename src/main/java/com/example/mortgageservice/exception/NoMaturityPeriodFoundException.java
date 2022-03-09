package com.example.mortgageservice.exception;

public class NoMaturityPeriodFoundException extends RuntimeException {

    public NoMaturityPeriodFoundException() {

        super("No data found");
    }
}