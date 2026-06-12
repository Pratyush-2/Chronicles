package com.chronicles.log.controller;

import com.chronicles.log.dto.RegionRequest;
import com.chronicles.log.entity.Region;
import com.chronicles.log.service.RegionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/regions")

public class RegionController {
    private final RegionService regionService;

    public RegionController(RegionService regionService){
        this.regionService = regionService;
    }

    @GetMapping
    public List<Region> getAllRegions(){
        return regionService.getAllRegions();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Region createRegion (@Valid @RequestBody RegionRequest request){
        Region region = new Region();
        region.setName(request.getName());
        region.setDescription(request.getDescription());
        return regionService.createRegion(region);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Region> getRegionById(@PathVariable long id){
        Region region = regionService.getRegionById(id);
        return ResponseEntity.ok(region);
    }
    @PutMapping("/{id}")
    public Region updateRegion(@PathVariable long id, @RequestBody Region region){
        return regionService.updateRegion(id,region);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRegion(@PathVariable long id){
        regionService.deleteRegion(id);
    }


}
