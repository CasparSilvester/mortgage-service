package com.example.mortgageservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(org.hibernate.PropertyValueException.class)
    public ResponseEntity<Object> handlePropertyValueException(
            org.hibernate.PropertyValueException ex) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Invalid JSON: refer to api-specifications at /api/v3/api-docs " +
                "or try testing at /api/swagger-ui/index.html");

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IDProvidedException.class)
    public ResponseEntity<Object> handleIDProvidedException(
            IDProvidedException ex) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Invalid JSON: id element not allowed");

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}