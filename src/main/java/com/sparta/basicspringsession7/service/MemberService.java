package com.sparta.basicspringsession7.service;

import com.sparta.basicspringsession7.dto.*;
import com.sparta.basicspringsession7.entity.Member;
import com.sparta.basicspringsession7.repository.MemberRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public MemberSaveResponseDto saveMember(MemberSaveRequestDto memberSaveResponseDto) {
        Member member = new Member(memberSaveResponseDto.getName());
        Member savedMember = memberRepository.save(member);
        return new MemberSaveResponseDto(savedMember.getId(), savedMember.getName());
    }

    public List<MemberSimpleResponseDto> getAllMembers() {
        List<Member> members = memberRepository.findAll();
        List<MemberSimpleResponseDto> dtoList = new ArrayList<>();
        for (Member member : members) {
            MemberSimpleResponseDto memberSimpleResponseDto = new MemberSimpleResponseDto(member.getId(), member.getName());
            dtoList.add(memberSimpleResponseDto);
        }
        return dtoList;
    }

    public MemberDetailResponseDto getMember(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(()-> new NullPointerException("해당 멤버를 찾을 수 없습니다"));
        return new MemberDetailResponseDto(member.getId(), member.getName());
    }

    @Transactional
    public MemberUpdateResponseDto updateMember(Long memberId, MemberUpdateRequestDto memberUpdateRequestDto) {
        Member member = memberRepository.findById(memberId).orElseThrow(()-> new NullPointerException("해당 멤버를 찾을 수 없습니다"));
        member.update(memberUpdateRequestDto.getName());
        return new MemberUpdateResponseDto(member.getId(), memberUpdateRequestDto.getName());
    }


    @Transactional
    public void deleteMember(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(()-> new NullPointerException("해당 멤버를 찾을 수 없습니다"));
        memberRepository.delete(member);
    }
}
