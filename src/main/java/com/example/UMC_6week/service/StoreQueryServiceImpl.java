package com.example.UMC_6week.service;

import com.example.UMC_6week.repository.MissionRepository;
import com.example.UMC_6week.repository.ReviewRepository;
import com.example.UMC_6week.repository.StoreRepository;
import com.example.UMC_6week.web.dto.MissionResponseDTO;
import com.example.UMC_6week.web.entity.Mission;
import com.example.UMC_6week.web.entity.Review;
import com.example.UMC_6week.web.entity.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService{

    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;
    private final MissionRepository missionRepository;

    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }


    @Override
    public Page<Review> getReviewList(Long StoreId, Integer page) {

        Store store = storeRepository.findById(StoreId).get();

        Page<Review> StorePage = reviewRepository.findAllByStore(store, PageRequest.of(page, 10));
        return StorePage;
    }
}