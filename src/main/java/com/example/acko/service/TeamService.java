package com.example.acko.service;

import com.example.acko.dtos.AddTeamDTO;
import com.example.acko.dtos.TeamDTO;
import com.example.acko.model.Developer;
import com.example.acko.model.Team;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TeamService {

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
        return addTeam.transformToDTO();
    }
}
