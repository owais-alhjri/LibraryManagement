package com.example.libraryManagement.services;

import com.example.libraryManagement.models.Book;
import com.example.libraryManagement.models.BorrowRecord;
import com.example.libraryManagement.models.BorrowRequest;
import com.example.libraryManagement.models.Member;
import com.example.libraryManagement.repository.BookRepository;
import com.example.libraryManagement.repository.BorrowRecordRepository;
import com.example.libraryManagement.repository.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BorrowRecordService {

    private final BorrowRecordRepository borrowRecordRepository;
    private final MemberRepository memberRepository;
    private final BookRepository bookRepository;

    public BorrowRecordService(BorrowRecordRepository borrowRecordRepository, MemberRepository memberRepository, BookRepository bookRepository) {
        this.borrowRecordRepository = borrowRecordRepository;
        this.memberRepository = memberRepository;
        this.bookRepository = bookRepository;
    }

    public  BorrowRecord borrowBook(BorrowRequest borrowRequest) throws Exception {

        //to check if the member exists by the id
        if(!memberRepository.existsById(borrowRequest.getMemberId())){
            throw new EntityNotFoundException("member Id not found");
        }

        // checking if the book is available or not
        Book book = bookRepository.findById(borrowRequest.getBookId())
                .orElseThrow(()-> new EntityNotFoundException("Book not found"));

        if (!book.getAvailable()){
            throw new EntityNotFoundException("Book is not available");
        }

        //checking if the member have more then 3 book or not
        Member member = memberRepository.getReferenceById(borrowRequest.getMemberId());
        List<BorrowRecord> records = member.getBorrowRecords();
        if (records.size() >= 3){
            throw new Exception("cannot borrow more than 3 books");
        }
        BorrowRecord borrowRecord = new BorrowRecord();
        borrowRecord.setMember(member);
        borrowRecord.setBook(book);
        borrowRecord.setBorrowDate(new Date());
        borrowRecord.setReturnDate(null);

        borrowRecordRepository.save(borrowRecord);

        book.setAvailable(false);
        bookRepository.save(book);

        return borrowRecord;
    }

    public BorrowRecord returnBookById(BorrowRequest borrowRequest){

        Long memberId = borrowRequest.getMemberId();
        Long bookId = borrowRequest.getBookId();

        Member member = memberRepository.findById(memberId)
                        .orElseThrow(()-> new EntityNotFoundException("Member not found"));

        Book book = bookRepository.findById(bookId)
                        .orElseThrow(()-> new EntityNotFoundException("Book not found"));

        BorrowRecord record = borrowRecordRepository
                .findByMemberIdAndBookIdAndReturnDateIsNull(memberId,bookId)
                        .orElseThrow(()->new EntityNotFoundException("No active borrow found fot this member and book"));

        book.setAvailable(true);
        bookRepository.save(book);

        record.setReturnDate(new Date());
        borrowRecordRepository.save(record);

        return record;

    }






}
