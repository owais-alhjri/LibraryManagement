package com.example.libraryManagement.controllers;

import com.example.libraryManagement.models.BorrowRecord;
import com.example.libraryManagement.models.BorrowRequest;
import com.example.libraryManagement.services.BorrowRecordService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class BorrowRecordController {

    private final BorrowRecordService borrowRecordService;

    public BorrowRecordController(BorrowRecordService borrowRecordService) {
        this.borrowRecordService = borrowRecordService;
    }

    @PostMapping("/borrow")
    public ResponseEntity<Map<String, Object>> borrowBook(@Valid @RequestBody BorrowRequest borrowRequest) throws Exception {
        BorrowRecord record  = borrowRecordService.borrowBook(borrowRequest);

        Map<String, Object> data = new HashMap<>();
        data.put("id", record.getId());
        data.put("userId", record.getUser().getId());
        data.put("bookId", record.getBook().getId());
        data.put("borrowDate", record.getBorrowDate());
        data.put("returnDate", record.getReturnDate());

        Map<String, Object> response = new HashMap<>();
        response.put("data", data);
        response.put("message", "Book borrowed successfully");

        return ResponseEntity.status(201).body(response);
    }



    @PostMapping("/return")
    public ResponseEntity<Map<String, Object>> returnBook(@Valid @RequestBody BorrowRequest borrowRequest ){
        BorrowRecord bookReturned = borrowRecordService.returnBookById(borrowRequest);
        Map<String, Object> response = new HashMap<>();
        response.put("data",bookReturned);
        response.put("message","Book returned successfully");

        return ResponseEntity.status(201).body(response);
    }

}
