package com.example.libraryManagement.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class BorrowRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties("borrowRecords")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "book_id",nullable = false)
    @JsonIgnoreProperties("borrowRecords")
    private Book book;


    @Temporal(TemporalType.TIMESTAMP)
    private Date borrowDate = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    private Date returnDate;
}
