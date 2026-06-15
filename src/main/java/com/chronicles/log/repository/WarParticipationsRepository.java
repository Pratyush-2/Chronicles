package com.chronicles.log.repository;

import com.chronicles.log.entity.WarParticipations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarParticipationsRepository extends JpaRepository<WarParticipations, Long> {
}
