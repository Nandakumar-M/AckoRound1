package com.example.acko.service;

import com.example.acko.dtos.AddTeamDTO;
import com.example.acko.dtos.TeamDTO;
import com.example.acko.model.Developer;
import com.example.acko.model.Team;
import com.example.acko.repositories.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    @Transactional
    public TeamDTO addTeam(AddTeamDTO team) {

        Team addTeam = new Team();
        addTeam.setName(team.getName());
        Set<Developer> developers = team.getDevelopers().stream()
                .map(dto -> {
                    Developer dev = new Developer();
                    dev.setName(dto.getName());
                    dev.setTeam(addTeam);
                    dev.setPhoneNo(dto.getPhoneNo());
                    return dev;
                })
                .collect(Collectors.toSet());
        addTeam.setDevelopers(developers);

        teamRepository.save(addTeam);

        return addTeam.transformToDTO();
    }
}
