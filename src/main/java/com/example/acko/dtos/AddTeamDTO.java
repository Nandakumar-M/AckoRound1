package com.example.acko.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class AddTeamDTO {

    @NotBlank
    @Length(max = 100, message = "Team name is too long")
    private String name;

    @Valid
    private List<AddDeveloperDTO> developers;


    @Getter
    @Setter
    @RequiredArgsConstructor
    public static class AddDeveloperDTO {
        @NotBlank
        @Length(max = 100, message = "Team name is too long")
        private String name;

        @NotBlank
        @Pattern(regexp = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$")
        private String phoneNo;
    }
}


