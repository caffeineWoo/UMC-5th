package com.example.UMC_6week.repository;

import com.example.UMC_6week.web.entity.Mission;
import com.example.UMC_6week.web.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long> {

}
