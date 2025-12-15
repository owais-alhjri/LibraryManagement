package com.example.libraryManagement.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleEntityNotFoundException(EntityNotFoundException ex){
        Map<String, Object> response = new HashMap<>();
        response.put("message",ex.getMessage());
        return ResponseEntity.status(404).body(response);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleNotValidException(MethodArgumentNotValidException ex){

        Map<String, Object> response = new HashMap<>();
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(),error.getDefaultMessage())
        );
        response.put("message","Validation failed");
        response.put("errors",errors);
        return ResponseEntity.status(400).body(response);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGlobalException(Exception ex){
        Map<String,Object> response = new HashMap<>();
        response.put("message","Something went wrong. Please try again later.");
        response.put("error",ex.getClass().getSimpleName());

        return ResponseEntity.status(500).body(response);
    }
}
