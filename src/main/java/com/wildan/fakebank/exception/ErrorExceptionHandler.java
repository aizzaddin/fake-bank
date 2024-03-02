package com.wildan.fakebank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ErrorExceptionHandler {
    @ExceptionHandler({ErrorException.class})
    public ResponseEntity<Object> handleException(ErrorException errorException) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        Map<String, Object> response = new HashMap<>();
        response.put("message", errorException.getMessage());
        response.put("status", status.value());
        return new ResponseEntity<>(response, status);
    }
}
