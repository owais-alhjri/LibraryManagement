package com.example.curdoprations.repository;

import com.example.curdoprations.models.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Long> {
    Optional<BorrowRecord> findByMemberIdAndBookIdAndReturnDateIsNull(Long memberId, Long bookId) ;
}