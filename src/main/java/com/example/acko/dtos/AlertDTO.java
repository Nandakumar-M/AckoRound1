package com.example.acko.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter @NoArgsConstructor
@Setter
public class AlertDTO {
    @NotNull
    private Long teamId;
    //private String message;
}
