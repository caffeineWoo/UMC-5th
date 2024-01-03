package com.example.UMC_6week.repository;

import com.example.UMC_6week.web.entity.Review;
import com.example.UMC_6week.web.entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findAllByStore(Store store, PageRequest pageRequest);
    Page<Review> findAllByMemberId( long Id, PageRequest pageRequest);

}
