package com.example.mortgageservice.exception;

public class IDProvidedException extends RuntimeException {

    public IDProvidedException() {

        super("No data found");
    }
}