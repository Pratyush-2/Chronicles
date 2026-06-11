package com.chronicles.log.repository;

import com.chronicles.log.entity.Civilization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CivilizationRepository extends JpaRepository<Civilization, Long> {
}
