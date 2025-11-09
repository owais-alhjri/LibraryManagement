package com.example.curdoprations.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
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
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "book_id",nullable = false)
    private Book book;


    @Temporal(TemporalType.TIMESTAMP)
    private Date borrowData = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    private Date returnDate;
}
