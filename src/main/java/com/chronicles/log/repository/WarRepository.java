package com.chronicles.log.repository;

import com.chronicles.log.entity.War;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarRepository extends JpaRepository<War, Long> {
}
