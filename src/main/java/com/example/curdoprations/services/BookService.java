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

}

