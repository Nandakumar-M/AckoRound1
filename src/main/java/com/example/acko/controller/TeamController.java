package com.example.acko.controller;

import com.example.acko.dtos.AddTeamDTO;
import com.example.acko.dtos.TeamDTO;
import com.example.acko.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/teams")
@RequiredArgsConstructor
public class TeamController {


    private final TeamService teamService;

    @PostMapping
    public TeamDTO addTeam(@Valid @RequestBody AddTeamDTO team) {

        return teamService.addTeam(team);
    }
}
