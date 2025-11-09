package com.example.curdoprations.repository;

import com.example.curdoprations.models.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Long> {
    Long countByMember_IdAndReturnDateIsNull(Long memberId);
}