package com.chronicles.log.repository;

import com.chronicles.log.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository
        extends JpaRepository<Region, Long> {
}