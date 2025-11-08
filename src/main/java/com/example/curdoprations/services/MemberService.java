package com.example.curdoprations.services;

import com.example.curdoprations.models.Member;
import com.example.curdoprations.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    public Member addMember(Member member){
         return memberRepository.save(member);
    }


}
