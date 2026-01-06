package com.example.libraryManagement.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookResponseDTO {


    private Long Id;
    private String title;
    private String author;
    private String isbn;
    private Boolean available;

}
