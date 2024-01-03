package com.example.UMC_6week.service;

import com.example.UMC_6week.Convertor.MemberConverter;
import com.example.UMC_6week.Convertor.MemberPreferConverter;
import com.example.UMC_6week.Convertor.StoreConverter;
import com.example.UMC_6week.apiPayload.code.status.ErrorStatus;
import com.example.UMC_6week.apiPayload.exception.handler.FoodCategoryHandler;
import com.example.UMC_6week.repository.FoodCategoryRepository;
import com.example.UMC_6week.repository.MemberRepository;
import com.example.UMC_6week.repository.RegionRepository;
import com.example.UMC_6week.repository.StoreRepository;
import com.example.UMC_6week.web.dto.MemberRequestDTO;
import com.example.UMC_6week.web.dto.StoreRequestDTO;
import com.example.UMC_6week.web.entity.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreCommandServiceImpl implements StoreCommandService{

    private final StoreRepository storeRepository;


    @Override
    @Transactional
    public Store registStore(Long regionId, StoreRequestDTO.AddStoreDto request) {

        Store store = StoreConverter.toStore(request);

        return storeRepository.save(store);
    }
    public boolean existById(List<Long> values) {
        boolean isValid = values.stream()
                .allMatch(value -> storeRepository.existsById(value));
        return isValid;
    }


}