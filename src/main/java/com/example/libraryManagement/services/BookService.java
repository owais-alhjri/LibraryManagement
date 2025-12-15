package com.example.libraryManagement.services;

import com.example.libraryManagement.models.Book;
import com.example.libraryManagement.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public Book addBook(Book book){
        return bookRepository.save(book);
    }
    public Book updateById(Book book,Long id){
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Book not found with ID: "+id));

        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setAvailable(book.getAvailable());
        existingBook.setIsbn(book.getIsbn());

        return bookRepository.save(existingBook);
    }

    public void deleteBookById(Long id){
        if (!bookRepository.existsById(id)){
            throw new EntityNotFoundException("Book Not Found");
        }
        bookRepository.deleteById(id);

    }


    public List<Book> findBookByAuthorOrTitle(String author, String title){
        if (author != null && !author.isBlank()){
            return bookRepository.findByAuthor(author);
        }
        if (title != null && !title.isBlank()){
            return bookRepository.findByTitle(title);

        }

        return  Collections.emptyList();
    }

}

