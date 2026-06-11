package com.chronicles.log.repository;

import com.chronicles.log.entity.Leader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaderRepository extends JpaRepository<Leader, Long> {
}
