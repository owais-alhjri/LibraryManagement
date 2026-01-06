package com.example.libraryManagement.dto;

import java.time.LocalDate;


public record BorrowedBookDTO (

     Long bookId,
     String title,
     String author,
     LocalDate borrowDate,
     LocalDate returnDate
     ){}
