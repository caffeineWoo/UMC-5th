package com.example.UMC_6week.web.controller;

import com.example.UMC_6week.Convertor.MemberConverter;
import com.example.UMC_6week.Convertor.StoreConverter;
import com.example.UMC_6week.apiPayload.ApiResponse;
import com.example.UMC_6week.repository.StoreRepository;
import com.example.UMC_6week.service.MemberCommandService;
import com.example.UMC_6week.service.StoreCommandService;
import com.example.UMC_6week.web.dto.MemberRequestDTO;
import com.example.UMC_6week.web.dto.MemberResponseDTO;
import com.example.UMC_6week.web.dto.StoreRequestDTO;
import com.example.UMC_6week.web.dto.StoreResponseDTO;
import com.example.UMC_6week.web.entity.Member;
import com.example.UMC_6week.web.entity.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
public class AddStoreController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/regions/{regionId}")
    public ApiResponse<StoreResponseDTO.JoinResultDTO> addStoreToRegion(
            @PathVariable Long regionId,
            @RequestBody @Valid StoreRequestDTO.AddStoreDto request){
        Store store = storeCommandService.registStore(regionId, request);
        return ApiResponse.onSuccess(StoreConverter.toJoinResultDTO(store));
    }
}