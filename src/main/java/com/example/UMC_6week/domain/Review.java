package com.example.UMC_6week.domain;

import com.example.UMC_6week.domain.common.BaseEntity;
import com.example.UMC_6week.domain.mapping.MemberMission;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String title;

    private Float score;
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;
}
