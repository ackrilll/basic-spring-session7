package com.sparta.basicspringsession7.repository;

import com.sparta.basicspringsession7.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
