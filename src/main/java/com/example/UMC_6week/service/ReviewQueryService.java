package com.example.UMC_6week.service;

import com.example.UMC_6week.web.entity.Review;
import com.example.UMC_6week.web.entity.Store;
import lombok.Getter;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ReviewQueryService {
//    Optional<Review> findreview(Long id);

    Page<Review> getReviewList(Long memberId, Integer page);
}
