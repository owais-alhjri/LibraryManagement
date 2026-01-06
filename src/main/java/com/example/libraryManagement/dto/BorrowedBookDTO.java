package com.example.libraryManagement.dto;


import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class BorrowedBookDTO {

    private Long bookId;
    private String title;
    private String author;
    private LocalDate borrowDate;
    private LocalDate returnDate;

}
