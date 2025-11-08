package com.example.curdoprations.services;

import com.example.curdoprations.models.Book;
import com.example.curdoprations.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public Book addBook(Book book){
        return bookRepository.save(book);
    }
    public Book updateById(Book book,Long id){
        try{
            Optional<Book> existingBook = bookRepository.findById(id);
            if(existingBook.isPresent()){
                Book bookEntity = existingBook.get();
                bookEntity.setTitle(book.getTitle());
                bookEntity.setAuthor(book.getAuthor());
                bookEntity.setAvailable(book.getAvailable());
                bookEntity.setIsbn(book.getIsbn());
                return bookRepository.save(bookEntity);
            }
        }catch (EntityNotFoundException error){
            throw error;
        }
        return null;
    }

}

