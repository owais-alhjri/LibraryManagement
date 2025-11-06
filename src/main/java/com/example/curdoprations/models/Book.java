package com.example.curdoprations.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotBlank(message = "Title is required")
    private String title;
    @NotEmpty(message = "Author cannot be empty")
    private String author;
    @Pattern(regexp = "\\d{13}",message = "ISBN must be 13 digits")
    private String isbn;

    @NotNull
    private  Boolean available;

    @JsonIgnore
    @OneToMany(mappedBy = "book")
    private List<BorrowRecord> borrowRecords;


}
