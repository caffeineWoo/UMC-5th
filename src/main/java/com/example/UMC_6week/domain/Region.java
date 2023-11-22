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
public class Region extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10)
    private String name;

//    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
//    private List<MemberMission> memberMissionList = new ArrayList<>();
}
