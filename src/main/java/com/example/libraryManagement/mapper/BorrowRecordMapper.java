package com.example.libraryManagement.mapper;

import com.example.libraryManagement.dto.BorrowBookDTO;
import com.example.libraryManagement.dto.BorrowRecordResponseDTO;
import com.example.libraryManagement.dto.BorrowedBookDTO;
import com.example.libraryManagement.models.BorrowRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BorrowRecordMapper {
    BorrowRecordResponseDTO toResponse(BorrowRecord borrowRecord);

    @Mapping(target = "id",ignore = true)
    @Mapping(target = "borrowDate",expression = "java(java.time.LocalDate.now())")
    @Mapping(target = "returnDate",constant = "null")
    BorrowRecord toEntity(BorrowBookDTO dto);

    BorrowedBookDTO toBorrowedBook(BorrowRecord record);


}
