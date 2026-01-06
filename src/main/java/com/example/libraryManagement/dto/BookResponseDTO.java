package com.example.libraryManagement.dto;


public record BookResponseDTO (

     Long id,
     String title,
     String author,
     String isbn,
     Boolean available

){}
