package com.example.libraryManagement.controllers;

import com.example.libraryManagement.models.BorrowRecord;
import com.example.libraryManagement.models.Member;
import com.example.libraryManagement.services.MemberService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping()
    public ResponseEntity<Map<String, Object>> registerMember(@Valid @RequestBody Member member){
        Member addMember = memberService.addMember(member);
        Map<String, Object> response = new HashMap<>();
        response.put("data",addMember);
        response.put("message","Member registered successfully");

        return ResponseEntity.status(201).body(response);
    }

    @GetMapping("/allMembers")
    public ResponseEntity<Map<String, Object>> allMembers(){
        List<Member> members =  memberService.fetchMembers();
        Map<String, Object> response = new HashMap<>();
        response.put("data",members);
        response.put("message","All Members");
        return ResponseEntity.ok(response);
    }


    @GetMapping("/{id}/borrowed")
    public ResponseEntity<Map<String, Object>> viewAllBorrowedBooks(@PathVariable Long id ){
            List<BorrowRecord> view = memberService.viewBooks(id);

        Map<String, Object> response = new HashMap<>();
        response.put("data",view);
        response.put("message","view all borrowed books");

        return ResponseEntity.ok(response);
    }

}
