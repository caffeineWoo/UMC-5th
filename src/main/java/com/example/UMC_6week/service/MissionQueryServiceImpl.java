package com.example.UMC_6week.service;

import com.example.UMC_6week.repository.MissionRepository;
import com.example.UMC_6week.repository.ReviewRepository;
import com.example.UMC_6week.repository.StoreRepository;
import com.example.UMC_6week.web.entity.Mission;
import com.example.UMC_6week.web.entity.Review;
import com.example.UMC_6week.web.entity.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService{
    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;
    private final MissionRepository missionRepository;
    @Override
    public Page<Mission> getStoreMissionList(Long storeId, Integer page) {
        Store store = storeRepository.findById(storeId).get();

        Page<Mission> StoreMissionList = missionRepository.findAllByStore(store, PageRequest.of(page, 10));
        return StoreMissionList;
    }

}