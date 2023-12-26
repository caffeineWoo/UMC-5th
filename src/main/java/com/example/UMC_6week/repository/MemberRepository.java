package com.example.UMC_6week.repository;

import com.example.UMC_6week.web.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}