package com.example.curdoprations.services;

import com.example.curdoprations.models.Book;
import com.example.curdoprations.models.BorrowRecord;
import com.example.curdoprations.models.BorrowRequest;
import com.example.curdoprations.models.Member;
import com.example.curdoprations.repository.BorrowRecordRepository;
import com.example.curdoprations.repository.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BorrowRecordService {

    private final BorrowRecordRepository borrowRecordRepository;
    private final MemberRepository memberRepository;

    public BorrowRecordService(BorrowRecordRepository borrowRecordRepository, MemberRepository memberRepository) {
        this.borrowRecordRepository = borrowRecordRepository;
        this.memberRepository = memberRepository;
    }

    public BorrowRequest borrowBook(BorrowRequest borrowRequest) throws Exception {
        if(!borrowRecordRepository.existsById(borrowRequest.getMemberId())){
            throw new EntityNotFoundException("member Id not found");
        }

        BorrowRecord book = borrowRecordRepository.getReferenceById(borrowRequest.getBookId());
        Book available = book.getBook();
        boolean t =  available.getAvailable();

        Member member = memberRepository.getReferenceById(borrowRequest.getMemberId());
        List<BorrowRecord> records = member.getBorrowRecords();
        if (records.size() > 3){
            throw new Exception("cannot borrow more than 3 books");
        }


        if (!borrowRecordRepository.existsById(borrowRequest.getBookId()) && (!t) ){
             throw new EntityNotFoundException("Book is not available");
        }

    }
}
