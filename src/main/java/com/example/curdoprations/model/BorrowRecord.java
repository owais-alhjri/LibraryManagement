package com.example.curdoprations.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class BorrowRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long memberId;
    private Long bookId;
    private Date borrowData;

    @Column(nullable = true)
    private Date returnDate;
}
