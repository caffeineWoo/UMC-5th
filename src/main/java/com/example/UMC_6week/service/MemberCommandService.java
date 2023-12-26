package com.example.UMC_6week.service;

import com.example.UMC_6week.web.dto.MemberRequestDTO;
import com.example.UMC_6week.web.entity.Member;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
}
