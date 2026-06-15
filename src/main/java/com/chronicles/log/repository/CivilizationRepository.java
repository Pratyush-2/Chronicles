package com.chronicles.log.repository;

import com.chronicles.log.entity.Civilization;
import org.springframework.data.jpa.repository.JpaRepository;


import com.chronicles.log.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CivilizationRepository extends JpaRepository<Civilization, Long> {
}
