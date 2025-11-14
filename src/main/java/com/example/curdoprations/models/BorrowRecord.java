package com.example.curdoprations.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JsonIgnoreProperties("borrowRecords")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "book_id",nullable = false)
    @JsonIgnoreProperties("borrowRecords")
    private Book book;


    @Temporal(TemporalType.TIMESTAMP)
    private Date borrowDate = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    private Date returnDate;
}
