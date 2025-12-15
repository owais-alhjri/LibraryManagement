package com.example.libraryManagement.repository;

import com.example.libraryManagement.models.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Long> {
    Optional<BorrowRecord> findByMemberIdAndBookIdAndReturnDateIsNull(Long memberId, Long bookId) ;

    List<BorrowRecord> findByMemberId(Long member);
}