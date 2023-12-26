package com.example.UMC_6week.service;

import com.example.UMC_6week.Convertor.MemberConverter;
import com.example.UMC_6week.Convertor.MemberPreferConverter;
import com.example.UMC_6week.apiPayload.code.status.ErrorStatus;
import com.example.UMC_6week.apiPayload.exception.handler.FoodCategoryHandler;
import com.example.UMC_6week.repository.FoodCategoryRepository;
import com.example.UMC_6week.web.dto.MemberRequestDTO;
import com.example.UMC_6week.web.entity.FoodCategory;
import com.example.UMC_6week.web.entity.Member;
import com.example.UMC_6week.repository.MemberRepository;
import com.example.UMC_6week.web.entity.MemberPrefer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }

    public boolean existById(List<Long> values) {
        boolean isValid = values.stream()
                .allMatch(value -> foodCategoryRepository.existsById(value));
        return isValid;
    }
}