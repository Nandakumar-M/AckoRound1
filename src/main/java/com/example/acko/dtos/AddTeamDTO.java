package com.example.acko.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter @Setter @RequiredArgsConstructor
public class AddTeamDTO {

    @NotBlank @Max(100)
    private String name;

    private List<AddDeveloperDTO> developers;


    @Getter @Setter @RequiredArgsConstructor
    public static class AddDeveloperDTO {
        @NotBlank @Max(100)
        private String name;

        @NotBlank @Pattern(regexp = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$")
        private String phoneNo;
    }
}


