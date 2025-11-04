package com.example.curdoprations.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class BorrowRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany()
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToMany()
    @JoinColumn(name = "book_id")
    private Book book;


    private Date borrowData;
    private Date returnDate;
}
