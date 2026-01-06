package com.example.libraryManagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class BookUpdateDTO {
    private String title;
    private String author;

    @Pattern(regexp = "\\d{13}",message = "ISBN must be 13 digits")
    private String isbn;

    private Boolean available;
}
