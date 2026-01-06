package com.example.libraryManagement.services;

import com.example.libraryManagement.models.BorrowRecord;
import com.example.libraryManagement.models.Users;
import com.example.libraryManagement.repository.BorrowRecordRepository;
import com.example.libraryManagement.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BorrowRecordRepository borrowRecordRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BorrowRecordRepository borrowRecordRepository) {
        this.userRepository = userRepository;
        this.borrowRecordRepository = borrowRecordRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }


    public Users addUser(Users users){
        users.setPassword(passwordEncoder.encode(users.getPassword()));
         return userRepository.save(users);
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = userRepository.findByEmail(email)
                .orElseThrow(()->new UsernameNotFoundException("User not found with email: "+ email));
        return User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();
    }
    public List<Users> fetchUser(){
        return userRepository.findAll();
    }


    public List<BorrowRecord> viewBooks(Long id){


        return borrowRecordRepository.findByUserId(id);
    }



}
