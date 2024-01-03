package com.example.UMC_6week.web.controller;

import com.example.UMC_6week.Convertor.MemberConverter;
import com.example.UMC_6week.service.MemberMissionService;
import com.example.UMC_6week.service.MissionQueryService;
import com.example.UMC_6week.service.ReviewQueryService;
import com.example.UMC_6week.vaildation.annotation.ExistStore;
import com.example.UMC_6week.web.dto.MemberRequestDTO;
import com.example.UMC_6week.web.dto.MemberResponseDTO;
import com.example.UMC_6week.service.MemberCommandService;
import com.example.UMC_6week.apiPayload.ApiResponse;
import com.example.UMC_6week.web.dto.StoreResponseDTO;
import com.example.UMC_6week.web.entity.Member;
import com.example.UMC_6week.web.entity.MemberMission;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;
    private final ReviewQueryService reviewQueryService;
    private final MemberMissionService memberMissionService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }
    @GetMapping("/{memberId}/review")
    @Operation(summary = "특정 유저의 리뷰 목록 조회 API",description = "특정 유정의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "member의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다."),
    })
    public ApiResponse<StoreResponseDTO.ReviewPreViewListDTO> getReviewList(@ExistStore @PathVariable(name = "memberId") Long memberId, @RequestParam(name = "page") Integer page){
        reviewQueryService.getReviewList(memberId,page);
        return null;
    }
    @GetMapping("/{memberId}/mission")
    @Operation(summary = "특정 유저의 미션 목록 조회 API",description = "특정 유정의 미션들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "member의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다."),
    })
    public ApiResponse<StoreResponseDTO.ReviewPreViewListDTO> getMissionList(@ExistStore @PathVariable(name = "memberId") Long memberId, @RequestParam(name = "page") Integer page){
        memberMissionService.allChallengeMission(memberId,page);
        return null;
    }
}