package com.example.curdoprations.controllers;

import com.example.curdoprations.models.Book;
import com.example.curdoprations.services.BookService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/books")
public class BookController {


    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

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
        Book updatedBook = bookService.updateById(book, id);

        Map<String, Object> response = new HashMap<>();
        response.put("data", updatedBook);
        response.put("message", "Book Updated successfully");

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteBook(@PathVariable Long id){
        bookService.deleteBookById(id);
        Map<String, Object> response = new HashMap<>();
        response.put("message","Book has been deleted");
        return ResponseEntity.ok(response);
    }




}
