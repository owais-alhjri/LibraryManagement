package com.example.libraryManagement.mapper;

import com.example.libraryManagement.dto.BorrowedBooksByUserDTO;
import com.example.libraryManagement.dto.CreateUserDTO;
import com.example.libraryManagement.dto.UserResponseDTO;
import com.example.libraryManagement.models.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {BorrowRecordMapper.class})
public interface UserMapper {
    UserResponseDTO toResponse(Users users);

    Users toEntity(CreateUserDTO dto);

    @Mapping(target = "borrowedBooks",source = "borrowRecords")
    BorrowedBooksByUserDTO toBorrowedBooksByUserDTO(Users users);
}
