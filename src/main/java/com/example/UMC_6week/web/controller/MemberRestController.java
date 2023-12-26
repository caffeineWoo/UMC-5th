package com.example.UMC_6week.web.controller;

import com.example.UMC_6week.Convertor.MemberConverter;
import com.example.UMC_6week.web.dto.MemberRequestDTO;
import com.example.UMC_6week.web.dto.MemberResponseDTO;
import com.example.UMC_6week.service.MemberCommandService;
import com.example.UMC_6week.apiPayload.ApiResponse;
import com.example.UMC_6week.web.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }
}