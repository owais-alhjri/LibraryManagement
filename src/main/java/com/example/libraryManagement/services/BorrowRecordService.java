package com.example.libraryManagement.services;

import com.example.libraryManagement.models.Book;
import com.example.libraryManagement.models.BorrowRecord;
import com.example.libraryManagement.models.BorrowRequest;
import com.example.libraryManagement.models.Users;
import com.example.libraryManagement.repository.BookRepository;
import com.example.libraryManagement.repository.BorrowRecordRepository;
import com.example.libraryManagement.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BorrowRecordService {

    private final BorrowRecordRepository borrowRecordRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public BorrowRecordService(BorrowRecordRepository borrowRecordRepository, UserRepository userRepository, BookRepository bookRepository) {
        this.borrowRecordRepository = borrowRecordRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    public  BorrowRecord borrowBook(BorrowRequest borrowRequest) throws Exception {

        //to check if the user exists by the id
        if(!userRepository.existsById(borrowRequest.getUserId())){
            throw new EntityNotFoundException("user Id not found");
        }

        // checking if the book is available or not
        Book book = bookRepository.findById(borrowRequest.getBookId())
                .orElseThrow(()-> new EntityNotFoundException("Book not found"));

        if (!book.getAvailable()){
            throw new EntityNotFoundException("Book is not available");
        }

        //checking if the user have more then 3 book or not
        Users users = userRepository.getReferenceById(borrowRequest.getUserId());
        List<BorrowRecord> records = users.getBorrowRecords();
        if (records.size() >= 3){
            throw new Exception("cannot borrow more than 3 books");
        }
        BorrowRecord borrowRecord = new BorrowRecord();
        borrowRecord.setUser(users);
        borrowRecord.setBook(book);
        borrowRecord.setBorrowDate(new Date());
        borrowRecord.setReturnDate(null);

        borrowRecordRepository.save(borrowRecord);

        book.setAvailable(false);
        bookRepository.save(book);

        return borrowRecord;
    }

    public BorrowRecord returnBookById(BorrowRequest borrowRequest){

        Long userId = borrowRequest.getUserId();
        Long bookId = borrowRequest.getBookId();

        Users users = userRepository.findById(userId)
                        .orElseThrow(()-> new EntityNotFoundException("user not found"));

        Book book = bookRepository.findById(bookId)
                        .orElseThrow(()-> new EntityNotFoundException("Book not found"));

        BorrowRecord record = borrowRecordRepository
                .findByUserIdAndBookIdAndReturnDateIsNull(userId,bookId)
                        .orElseThrow(()->new EntityNotFoundException("No active borrow found fot this user and book"));

        book.setAvailable(true);
        bookRepository.save(book);

        record.setReturnDate(new Date());
        borrowRecordRepository.save(record);

        return record;

    }






}
