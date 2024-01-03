package com.example.UMC_6week.service;


import com.example.UMC_6week.domain.enums.MissionStatus;
import com.example.UMC_6week.repository.MemberMissionRepository;
import com.example.UMC_6week.repository.MemberRepository;
import com.example.UMC_6week.web.entity.Member;
import com.example.UMC_6week.web.entity.MemberMission;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberMissionService {

    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void challengeMission(Long memberId, Long missionId) {
        MemberMission memberMission = memberMissionRepository.findByMemberIdAndMissionId(memberId, missionId)
                .orElseThrow(() -> new RuntimeException("MemberMission not found"));

        if (memberMission.getStatus() == null) {
            memberMission.setStatus(MissionStatus.CHALLENGING);
            // 여기서 다른 처리도 추가할 수 있습니다.
        } else {
            throw new RuntimeException("MemberMission is already in a state other than null");
        }
    }
    public Page<MemberMission> allChallengeMission(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId).get();
        Page<MemberMission> memberMissionList = memberMissionRepository.findAllByMember(member, PageRequest.of(page, 10));
        return memberMissionList;
    }
}