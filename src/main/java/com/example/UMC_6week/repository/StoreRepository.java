package com.example.UMC_6week.repository;

import com.example.UMC_6week.web.entity.Mission;
import com.example.UMC_6week.web.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long> {
    Store findById(long storeId);
//    List<Mission> findAllByStore(Store store);
}
