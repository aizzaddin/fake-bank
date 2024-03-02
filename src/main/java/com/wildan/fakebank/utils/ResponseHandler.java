package com.wildan.fakebank.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> successResponse(Object data) {
        HttpStatus status = HttpStatus.OK;
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Success");
        response.put("status", status.value());
        response.put("response", data);

        return new ResponseEntity<>(response, status);
    }

    public static ResponseEntity<Object> successResponseWithoutData() {
        HttpStatus status = HttpStatus.OK;
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Success");
        response.put("status", status.value());

        return new ResponseEntity<>(response, status);
    }

    public static ResponseEntity<Object> customResponse(String message, HttpStatus status, Object data) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("status", status.value());
        response.put("response", data);

        return new ResponseEntity<>(response, status);
    }
}
