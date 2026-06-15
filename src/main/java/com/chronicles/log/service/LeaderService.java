package com.chronicles.log.service;

import com.chronicles.log.dto.LeaderRequest;
import com.chronicles.log.entity.Civilization;
import com.chronicles.log.entity.Leader;
import com.chronicles.log.exception.ResourceNotFoundException;
import com.chronicles.log.repository.CivilizationRepository;
import com.chronicles.log.repository.LeaderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaderService {

    private final LeaderRepository leaderRepository;
    private final CivilizationRepository civilizationRepository;
    public LeaderService(LeaderRepository leaderRepository, CivilizationRepository civilizationRepository) {
        this.leaderRepository = leaderRepository;
        this.civilizationRepository = civilizationRepository;
    }
    public Leader createLeader(LeaderRequest request) {
        Civilization civilization = civilizationRepository.findById(request.getCivilizationId()).orElseThrow(
                () -> new ResourceNotFoundException(
                        "Civilization not found with Id "
                                + request.getCivilizationId()
                )
        );
        Leader leader = new Leader();
        leader.setName(request.getName());
        leader.setTitle(request.getTitle());
        leader.setBirthYear(request.getBirthYear());
        leader.setDeathYear(request.getDeathYear());
        leader.setCivilization(civilization);
        leader.setDescription(request.getDescription());
        return leaderRepository.save(leader);

    }
    public Leader getLeaderById(Long id){
        return leaderRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Leader not found with id"+id));
    }
    public List <Leader> getAllLeaders(){
        return leaderRepository.findAll();
    }
    public void deleteLeaderById(long id){
        Leader existing = getLeaderById(id);
        leaderRepository.delete(existing);
    }
    public Leader updateLeader(Long id, LeaderRequest request){
        Leader existing = getLeaderById(id);
        existing.setName(request.getName());
        existing.setTitle(request.getTitle());
        existing.setBirthYear(request.getBirthYear());
        existing.setDeathYear(request.getDeathYear());
        existing.setDescription(request.getDescription());

        if (request.getCivilizationId() != null) {
            Civilization civilization = civilizationRepository.findById(request.getCivilizationId())
                    .orElseThrow(() -> new ResourceNotFoundException("Civilization not found with Id " + request.getCivilizationId()));
            existing.setCivilization(civilization);
        }

        return leaderRepository.save(existing);
    }

}
