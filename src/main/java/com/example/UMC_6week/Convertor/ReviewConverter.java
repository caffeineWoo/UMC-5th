package com.example.UMC_6week.Convertor;

import com.example.UMC_6week.web.dto.ReviewRequestDto;
import com.example.UMC_6week.web.dto.ReviewResponseDto;
import com.example.UMC_6week.web.entity.Review;
import com.example.UMC_6week.web.entity.Store;

import java.time.LocalDateTime;

public class ReviewConverter {
    public static Review toReview(ReviewRequestDto.ReviewDTO request, Store store) {
        return Review.builder()
                .title(request.getTitle())
                .score(request.getScore())
                .body(request.getBody())
                .store(store)
                .build();
    }

    public static ReviewResponseDto.RegistResultDto toRegistResultDto(Review review){
        return ReviewResponseDto.RegistResultDto.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
