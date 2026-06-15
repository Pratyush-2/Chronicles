package com.chronicles.log.controller;

import com.chronicles.log.dto.LeaderRequest;
import com.chronicles.log.entity.Leader;
import com.chronicles.log.service.LeaderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leaders")
public class LeaderController {
    private final LeaderService leaderService;
    public LeaderController(LeaderService leaderService) {
        this.leaderService = leaderService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Leader createLeader(@Valid @RequestBody LeaderRequest request){
        return leaderService.createLeader(request);

    }
    @GetMapping("/{id}")
    public Leader getLeaderService(@PathVariable long id){
        return leaderService.getLeaderById(id);
    }
    @GetMapping
    public List<Leader> getAllLeaders(){
        return leaderService.getAllLeaders();
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLeader(@PathVariable long id){
        leaderService.deleteLeaderById(id);
    }
    @PutMapping("/{id}")
    public Leader updateLeader(@PathVariable long id, @Valid @RequestBody LeaderRequest request){
        return leaderService.updateLeader(id, request);

    }

}
