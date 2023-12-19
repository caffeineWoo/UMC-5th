package com.example.UMC_6week.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {

    private TempResponse.TempTestDTO dto;
    private String code;
}
