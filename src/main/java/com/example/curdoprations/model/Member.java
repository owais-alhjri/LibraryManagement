package com.example.curdoprations.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @ManyToMany(mappedBy = "member")
    private List<BorrowRecord> borrowRecords;
}
