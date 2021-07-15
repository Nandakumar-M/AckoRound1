package com.example.acko.controller;

import com.example.acko.dtos.AlertDTO;
import com.example.acko.service.AlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/alerts")
@RequiredArgsConstructor
public class AlertController {

    private final AlertService alertService;
    @PostMapping
    public void raiseAlert(@Valid @RequestBody AlertDTO dto) {

        alertService.alertTeam(dto.getTeamId());
    }
}
