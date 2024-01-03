package com.example.UMC_6week.service;

import com.example.UMC_6week.web.entity.Mission;
import com.example.UMC_6week.web.entity.Review;
import com.example.UMC_6week.web.entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public interface StoreQueryService {
    Optional<Store> findStore(Long id);
//    Store getStore(Long id);

    Page<Review> getReviewList(Long StoreId, Integer page);
}
