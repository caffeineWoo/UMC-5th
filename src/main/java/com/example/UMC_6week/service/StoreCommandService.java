package com.example.UMC_6week.service;

import com.example.UMC_6week.web.dto.MemberRequestDTO;
import com.example.UMC_6week.web.dto.StoreRequestDTO;
import com.example.UMC_6week.web.entity.Member;
import com.example.UMC_6week.web.entity.Store;

public interface StoreCommandService {
    Store registStore(Long regionId, StoreRequestDTO.AddStoreDto request);
}
