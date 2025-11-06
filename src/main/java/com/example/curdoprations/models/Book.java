package com.example.curdoprations.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Book {
    @Id
    private Long Id;

    private String title;
    private String author;
    private String isbn;
    private  boolean available;

    @OneToMany(mappedBy = "book")
    private List<BorrowRecord> borrowRecords;


}
