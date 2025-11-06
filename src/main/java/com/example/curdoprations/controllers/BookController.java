package com.example.curdoprations.controllers;

import com.example.curdoprations.models.Book;
import com.example.curdoprations.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping()
    public ResponseEntity<Map<String, Object>> fetchBooks(){
        List<Book> book =  bookService.getBooks();
        Map<String, Object> response = new  HashMap<>();
        response.put("data",book);
        response.put("message", book.isEmpty() ? "No Books available ": "Books available");

        return ResponseEntity.ok(response);
    }
}
