package com.example.libraryManagement.dto;

import java.time.LocalDate;


public record BorrowRecordResponseDTO (

     Long id,
     Long userId,
     Long bookId,
     LocalDate borrowDate,
     LocalDate returnDate
){}
