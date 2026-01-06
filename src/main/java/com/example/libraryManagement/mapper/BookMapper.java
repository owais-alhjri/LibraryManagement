package com.example.libraryManagement.mapper;

import com.example.libraryManagement.dto.BookCreateDTO;
import com.example.libraryManagement.dto.BookResponseDTO;
import com.example.libraryManagement.dto.BookUpdateDTO;
import com.example.libraryManagement.models.Book;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookResponseDTO toResponse(Book book);
    Book toEntity(BookCreateDTO dto);
    void updateEntity(BookUpdateDTO dto, @MappingTarget Book book);
}
