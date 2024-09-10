package com.sparta.basicspringsession7.controller;

import com.sparta.basicspringsession7.dto.*;
import com.sparta.basicspringsession7.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/members")
    public ResponseEntity<MemberSaveResponseDto> saveMember(@RequestBody MemberSaveRequestDto memberSaveResponseDto){
        return ResponseEntity.ok(memberService.saveMember(memberSaveResponseDto));
    }

    @GetMapping("/members")
    public ResponseEntity<List<MemberSimpleResponseDto>> getAllMembers(){
        return ResponseEntity.ok(memberService.getAllMembers());
    }

    @GetMapping("/members/{memberId}")
    public ResponseEntity<MemberDetailResponseDto> getMember(@PathVariable("memberId") Long memberId){
        return ResponseEntity.ok(memberService.getMember(memberId));
    }

    @PutMapping("/members/{memberId}")
    public ResponseEntity<MemberUpdateResponseDto> updateMember(@PathVariable("memberId") Long memberId, @RequestBody MemberUpdateRequestDto memberUpdateRequestDto){
        return ResponseEntity.ok(memberService.updateMember(memberId,memberUpdateRequestDto));
    }

    @DeleteMapping("/members/{memberId}")
    public void deleteMember(@PathVariable("memberId") Long memberId){
        memberService.deleteMember(memberId);
    }
}
