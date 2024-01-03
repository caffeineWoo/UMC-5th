package com.example.UMC_6week.service;

import com.example.UMC_6week.web.entity.Mission;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface MissionQueryService {
//    Optional<Review> findReview(Long id);

    Page<Mission> getStoreMissionList(Long store, Integer page);
//    Page<Mission> getMemberMissionList(Long memberId, Integer page);

}
