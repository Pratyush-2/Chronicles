package com.chronicles.log.service;

import com.chronicles.log.dto.CivilizationRequest;
import com.chronicles.log.entity.Civilization;
import com.chronicles.log.entity.Region;
import com.chronicles.log.exception.ResourceNotFoundException;
import com.chronicles.log.repository.CivilizationRepository;
import com.chronicles.log.repository.RegionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CivilizationService {

    private final CivilizationRepository civilizationRepository;
    private final RegionRepository regionRepository;

    public CivilizationService(
            CivilizationRepository civilizationRepository,
            RegionRepository regionRepository) {

        this.civilizationRepository = civilizationRepository;
        this.regionRepository = regionRepository;
    }

    public Civilization createCivilization(
            CivilizationRequest request) {

        // Find Region
        Region region = regionRepository.findById(
                        request.getRegionId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Region not found"));

        // Create Civilization
        Civilization civilization = new Civilization();

        // Copy DTO -> Entity
        civilization.setName(request.getName());
        civilization.setFoundedYear(request.getFoundedYear());
        civilization.setCollapsedYear(request.getCollapsedYear());
        civilization.setDescription(request.getDescription());

        // Attach Region
        civilization.setRegion(region);

        // Save
        return civilizationRepository.save(civilization);
    }
    public Civilization getCivilizationById(Long id) {
        return civilizationRepository.findById(id).orElseThrow(()->new  ResourceNotFoundException("Civilization not found"));
    }
    public List<Civilization> getAllCivilizations() {
        return civilizationRepository.findAll();
    }
    public Civilization updateCivilization(Long id,CivilizationRequest civilizationRequest){
        Civilization existing = getCivilizationById(id);
        existing.setName(civilizationRequest.getName());
        existing.setFoundedYear(civilizationRequest.getFoundedYear());
        existing.setCollapsedYear(civilizationRequest.getCollapsedYear());
        existing.setDescription(civilizationRequest.getDescription());

        if (civilizationRequest.getRegionId() != null) {
            Region region = regionRepository.findById(civilizationRequest.getRegionId())
                    .orElseThrow(() -> new ResourceNotFoundException("Region not found"));
            existing.setRegion(region);
        }
        return civilizationRepository.save(existing);
    }
    public void deleteCivilizationById(Long id){
        Civilization existing = getCivilizationById(id);
        civilizationRepository.delete(existing);
    }

}
