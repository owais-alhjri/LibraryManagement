package com.example.libraryManagement.services;

import com.example.libraryManagement.models.BorrowRecord;
import com.example.libraryManagement.models.Member;
import com.example.libraryManagement.repository.BorrowRecordRepository;
import com.example.libraryManagement.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final BorrowRecordRepository borrowRecordRepository;

    public MemberService(MemberRepository memberRepository, BorrowRecordRepository borrowRecordRepository) {
        this.memberRepository = memberRepository;
        this.borrowRecordRepository = borrowRecordRepository;
    }


    public Member addMember(Member member){
         return memberRepository.save(member);
    }

    public List<Member> fetchMembers(){
        return memberRepository.findAll();
    }


    public List<BorrowRecord> viewBooks(Long id){


        return borrowRecordRepository.findByMemberId(id);
    }


}
