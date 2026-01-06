package com.example.libraryManagement.dto;

public record UserResponseDTO (
     Long id,
     String name,
     String email,
     String role
){}
