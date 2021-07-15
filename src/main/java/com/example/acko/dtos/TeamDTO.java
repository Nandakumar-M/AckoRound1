package com.example.acko.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class TeamDTO {
    private final Long id;
    private final String name;
    private final List<DeveloperDTO> developers;
}
