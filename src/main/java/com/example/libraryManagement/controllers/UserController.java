package com.example.libraryManagement.controllers;

import com.example.libraryManagement.models.BorrowRecord;
import com.example.libraryManagement.models.Users;
import com.example.libraryManagement.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<Map<String, Object>> registerUser(@Valid @RequestBody Users users){
        Users addUsers = userService.addUser(users);
        Map<String, Object> response = new HashMap<>();
        response.put("data", addUsers);
        response.put("message","User registered successfully");

        return ResponseEntity.status(201).body(response);
    }

    @GetMapping("/allUsers")
    public ResponseEntity<Map<String, Object>> allUsers(){
        List<Users> users =  userService.fetchUser();
        Map<String, Object> response = new HashMap<>();
        response.put("data", users);
        response.put("message","All Users");
        return ResponseEntity.ok(response);
    }


    @GetMapping("/{id}/borrowed")
    public ResponseEntity<Map<String, Object>> viewAllBorrowedBooks(@PathVariable Long id ){
            List<BorrowRecord> view = userService.viewBooks(id);

        Map<String, Object> response = new HashMap<>();
        response.put("data",view);
        response.put("message","view all borrowed books");

        return ResponseEntity.ok(response);
    }

}
