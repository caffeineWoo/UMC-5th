package com.example.UMC_6week.web.controller;

import com.example.UMC_6week.Convertor.ReviewConverter;
import com.example.UMC_6week.apiPayload.ApiResponse;
import com.example.UMC_6week.service.ReviewCommandService;
import com.example.UMC_6week.service.ReviewQueryService;
import com.example.UMC_6week.vaildation.annotation.ExistStore;
import com.example.UMC_6week.web.dto.ReviewRequestDto;
import com.example.UMC_6week.web.dto.ReviewResponseDto;
import com.example.UMC_6week.web.dto.StoreResponseDTO;
import com.example.UMC_6week.web.entity.Review;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reviews")
public class ReviewRestController {
    private final ReviewCommandService reviewCommandService;

    @PostMapping("/stores/{storeId}")
    public ApiResponse<ReviewResponseDto.RegistResultDto> addReviewToStore(
            @PathVariable Long storeId,
            @RequestBody ReviewRequestDto.ReviewDTO request){
        Review review = reviewCommandService.registReview(storeId, request);
        return ApiResponse.onSuccess(ReviewConverter.toRegistResultDto(review));
    }


}