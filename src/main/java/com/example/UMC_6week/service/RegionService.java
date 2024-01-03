package com.example.UMC_6week.service;


import com.example.UMC_6week.apiPayload.code.status.ErrorStatus;
import com.example.UMC_6week.apiPayload.exception.handler.RegionHandler;
import com.example.UMC_6week.repository.RegionRepository;
import com.example.UMC_6week.web.dto.RegionDTO;
import com.example.UMC_6week.web.dto.StoreDTO;
import com.example.UMC_6week.web.entity.Region;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RegionService {

    private final RegionRepository regionRepository;

    public boolean existsById(Long regionId) {
        return regionRepository.existsById(regionId);
    }


    public RegionDTO getRegionWithStoreList(Long regionId) {
        Region region = regionRepository.findById(regionId)
                .orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND));

        // 간단한 매핑 예제
        RegionDTO regionDTO = new RegionDTO();
        regionDTO.setId(region.getId());
        regionDTO.setName(region.getName());

        // StoreDTO 리스트를 생성하고 매핑
        List<StoreDTO> storeDTOList = region.getStoreList().stream()
                .map(store -> {
                    StoreDTO storeDTO = new StoreDTO();
                    storeDTO.setId(store.getId());
                    storeDTO.setName(store.getName());
                    return storeDTO;
                })
                .collect(Collectors.toList());

        regionDTO.setStoreList(storeDTOList);

        return regionDTO;
    }
}