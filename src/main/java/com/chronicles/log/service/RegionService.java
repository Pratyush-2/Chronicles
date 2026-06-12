package com.chronicles.log.service;

import com.chronicles.log.dto.RegionRequest;
import com.chronicles.log.entity.Region;
import com.chronicles.log.exception.ResourceNotFoundException;
import com.chronicles.log.repository.RegionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {
    private final RegionRepository regionRepository;

    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }
    public List<Region> getAllRegions(){
        return regionRepository.findAll();
    }
    public Region createRegion(Region region)
    {
        return regionRepository.save(region);
    }
    public Region getRegionById(long id){
        return regionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Region not found"));
    }
    public Region updateRegion(long id,Region updatedRegion){
        Region existing = getRegionById(id);
        existing.setName(updatedRegion.getName());
        existing.setDescription(updatedRegion.getDescription());
        return  regionRepository.save(existing);
    }
    public void deleteRegion(long id){
        Region existing = getRegionById(id);
        regionRepository.delete(existing);
    }

}
