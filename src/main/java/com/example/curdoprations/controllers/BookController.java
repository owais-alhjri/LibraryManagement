package com.example.curdoprations.controllers;

import com.example.curdoprations.models.Book;
import com.example.curdoprations.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping()
    public ResponseEntity<Map<String, Object>> addBook(@Valid @RequestBody Book book){
        Book addBook = bookService.addBook(book);

        Map<String, Object> response = new HashMap<>();
        response.put("data",addBook);
        response.put("message","Book Add Successfully");

        return ResponseEntity.status(201).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateBook(@Valid @RequestBody Book book, @PathVariable long id){
        Book updateBook = bookService.updateById(book, id);
        Map<String, Object> response = new HashMap<>();
        if (updateBook != null) {
            response.put("data", updateBook);
            response.put("message", "Book Updated");
            return ResponseEntity.ok(response);
        }
        response.put("message","Book Not Found");
        return ResponseEntity.status(404).body(response);
    }
}
