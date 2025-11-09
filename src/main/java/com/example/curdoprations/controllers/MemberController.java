package com.example.curdoprations.controllers;

import com.example.curdoprations.models.Member;
import com.example.curdoprations.services.MemberService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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



}
