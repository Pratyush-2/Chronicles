package com.chronicles.log.controller;


import com.chronicles.log.dto.CivilizationRequest;
import com.chronicles.log.entity.Civilization;
import com.chronicles.log.service.CivilizationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/civilizations")
public class CivilizationController {
    private final CivilizationService civilizationService;
    public CivilizationController(CivilizationService civilizationService) {
        this.civilizationService = civilizationService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Civilization createCivilization(@Valid @RequestBody CivilizationRequest request){
        return civilizationService.createCivilization(request);
    }
    @GetMapping("/{id}")
    public Civilization getCivilizationById(@PathVariable long id){
        return civilizationService.getCivilizationById(id);

    }
    @GetMapping
    public List<Civilization> getAllCivilizations(){
        return civilizationService.getAllCivilizations();
    }
    @PutMapping("/{id}")
    public Civilization updateCivilization(@PathVariable long id,@Valid @RequestBody CivilizationRequest civilizationRequest){
        return civilizationService.updateCivilization(id,civilizationRequest);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCivilization(@PathVariable long id){
        civilizationService.deleteCivilizationById(id);
    }


}
