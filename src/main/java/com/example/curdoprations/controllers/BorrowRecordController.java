package com.example.curdoprations.controllers;

import com.example.curdoprations.models.BorrowRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/borrowRecord")
public class BorrowRecordController {
    public ResponseEntity<Map<String, Object>> borrowBook(@Valid @RequestBody BorrowRequest borrowRequest){
        Map<String, Object> response = new HashMap<>();
        response.put("message",response);

        return ResponseEntity.status(201).body(response);
    }
}
