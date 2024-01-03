package com.example.UMC_6week.service;

import com.example.UMC_6week.repository.ReviewRepository;
import com.example.UMC_6week.repository.StoreRepository;
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
public class ReviewQueryServiceImpl implements ReviewQueryService{

    private final ReviewRepository reviewRepository;

    @Override
    public Page<Review> getReviewList(Long memberId, Integer page) {

        Page<Review> MemberReviewPage = reviewRepository.findAllByMemberId( memberId, PageRequest.of(page, 10));
        return MemberReviewPage;
    }
}