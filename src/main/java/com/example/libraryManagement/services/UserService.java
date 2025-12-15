package com.example.libraryManagement.services;

import com.example.libraryManagement.models.BorrowRecord;
import com.example.libraryManagement.models.Users;
import com.example.libraryManagement.repository.BorrowRecordRepository;
import com.example.libraryManagement.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BorrowRecordRepository borrowRecordRepository;

    public UserService(UserRepository userRepository, BorrowRecordRepository borrowRecordRepository) {
        this.userRepository = userRepository;
        this.borrowRecordRepository = borrowRecordRepository;
    }


    public Users addUser(Users users){
         return userRepository.save(users);
    }

    public List<Users> fetchUser(){
        return userRepository.findAll();
    }


    public List<BorrowRecord> viewBooks(Long id){


        return borrowRecordRepository.findByUserId(id);
    }


}
