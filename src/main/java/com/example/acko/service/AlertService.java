package com.example.acko.service;

import com.example.acko.exceptions.AckoEntityNotFoundException;
import com.example.acko.exceptions.AckoNoDeveloperPresentException;
import com.example.acko.model.Developer;
import com.example.acko.model.Team;
import com.example.acko.repositories.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AlertService {

    private final TeamRepository teamRepository;
    private final SMSNotificationService smsNotificationService;

    @Transactional(readOnly = true)
    public void alertTeam(Long teamId) {
        Team team = teamRepository.findById(teamId).orElseThrow(AckoEntityNotFoundException::new);
        Developer devToNotify = team.getDevelopers()
                .stream()
                .findAny()
                .orElseThrow(AckoNoDeveloperPresentException::new);
        smsNotificationService.notifyBySMS(devToNotify.getPhoneNo(), "Alert has been raised for your team!");
    }
}