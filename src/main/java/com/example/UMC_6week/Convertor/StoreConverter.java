package com.example.UMC_6week.Convertor;

import com.example.UMC_6week.domain.enums.Gender;
import com.example.UMC_6week.web.dto.MemberRequestDTO;
import com.example.UMC_6week.web.dto.MemberResponseDTO;
import com.example.UMC_6week.web.dto.StoreRequestDTO;
import com.example.UMC_6week.web.dto.StoreResponseDTO;
import com.example.UMC_6week.web.entity.Member;
import com.example.UMC_6week.web.entity.Store;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class StoreConverter {

    public static StoreResponseDTO.JoinResultDTO toJoinResultDTO(Store Store){
        return StoreResponseDTO.JoinResultDTO.builder()
                .Id(Store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.AddStoreDto request){

        return Store.builder()
                .address(request.getAddress())
                .name(request.getName())
                .score(request.getScore())
                .region(request.getRegion())
                .build();
    }
}