package com.example.acko.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class DeveloperDTO {
    private final Long id;
    private final String name;
    private final String phoneNo;
}
