package com.example.libraryManagement.controllers;

import com.example.libraryManagement.models.Book;
import com.example.libraryManagement.services.BookService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasRole('MEMBER')")
    public ResponseEntity<Map<String, Object>> fetchBooks(){
        List<Book> book =  bookService.getBooks();
        Map<String, Object> response = new  HashMap<>();
        response.put("data",book);
        response.put("message", book.isEmpty() ? "No Books available ": "Books available");

        return ResponseEntity.ok(response);
    }

    @PostMapping()
    @PreAuthorize("hasRole('LIBRARIAN')")
    public ResponseEntity<Map<String, Object>> addBook(@Valid @RequestBody Book book){
        Book addBook = bookService.addBook(book);

        Map<String, Object> response = new HashMap<>();
        response.put("data",addBook);
        response.put("message","Book Add Successfully");

        return ResponseEntity.status(201).body(response);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('LIBRARIAN')")
    public ResponseEntity<Map<String, Object>> updateBook(@Valid @RequestBody Book book, @PathVariable long id){
        Book updatedBook = bookService.updateById(book, id);

        Map<String, Object> response = new HashMap<>();
        response.put("data", updatedBook);
        response.put("message", "Book Updated successfully");

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('LIBRARIAN')")
    public ResponseEntity<Map<String, Object>> deleteBook(@PathVariable Long id){
        bookService.deleteBookById(id);
        Map<String, Object> response = new HashMap<>();
        response.put("message","Book has been deleted");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/search")
    @PreAuthorize("hasRole('MEMBER')")
    public ResponseEntity<Map<String, Object>> findBookByAuthor(@RequestParam(defaultValue = "")
                                                                    String author,
                                                                @RequestParam(defaultValue = "")
                                                                String title){
        List<Book> bookByAuthor = bookService.findBookByAuthorOrTitle(author, title);
        Map<String, Object> response = new HashMap<>();
        response.put("data",bookByAuthor);
        response.put("message","List of books by author or title");
        return ResponseEntity.ok(response);

    }



}
