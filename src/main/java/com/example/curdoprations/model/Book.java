package com.example.curdoprations.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id
    private Long Id;

    private String title;
    private String author;
    private String isbn;
    private  boolean available;


}
