package com.example.UMC_6week.service;


import com.example.UMC_6week.web.dto.ReviewRequestDto;
import com.example.UMC_6week.web.entity.Review;

public interface ReviewCommandService {

    Review registReview(Long storeId, ReviewRequestDto.ReviewDTO request);

}