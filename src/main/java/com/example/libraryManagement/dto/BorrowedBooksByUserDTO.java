package com.example.libraryManagement.dto;


import java.util.List;


public record BorrowedBooksByUserDTO (
     Long id,
     String name,
     String email,
     List<BorrowedBookDTO> borrowedBooks
){}
