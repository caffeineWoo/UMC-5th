package com.example.UMC_6week.service;


import com.example.UMC_6week.Convertor.ReviewConverter;
import com.example.UMC_6week.apiPayload.code.status.ErrorStatus;
import com.example.UMC_6week.apiPayload.exception.handler.StoreHandler;
import com.example.UMC_6week.repository.ReviewRepository;
import com.example.UMC_6week.repository.StoreRepository;
import com.example.UMC_6week.web.dto.ReviewRequestDto;
import com.example.UMC_6week.web.entity.Review;
import com.example.UMC_6week.web.entity.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewCommandServiceImpl implements ReviewCommandService{

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public Review registReview(Long storeId, ReviewRequestDto.ReviewDTO request){

        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        Review review = ReviewConverter.toReview(request, store);

        store.getReviewList().add(review);

        return reviewRepository.save(review);



    };
    public boolean existById(List<Long> values) {
        boolean isValid = values.stream()
                .allMatch(value -> reviewRepository.existsById(value));
        return isValid;
    }

}