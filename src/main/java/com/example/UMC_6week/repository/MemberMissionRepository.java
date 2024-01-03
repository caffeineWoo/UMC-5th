package com.example.UMC_6week.repository;

import com.example.UMC_6week.web.entity.Member;
import com.example.UMC_6week.web.entity.MemberMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    Optional<MemberMission> findByMemberIdAndMissionId(Long memberId, Long missionId);
    Page<MemberMission> findAllByMember(Member member, PageRequest pageRequest);
}