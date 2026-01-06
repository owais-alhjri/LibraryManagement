package com.example.libraryManagement.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BorrowRecordResponseDTO {

    private Long id;

    private Long userId;

    private Long bookId;

    private LocalDate borrowDate;

    private LocalDate returnDate;
}
