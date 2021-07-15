package com.example.acko.model;

import com.example.acko.dtos.DeveloperDTO;
import com.example.acko.dtos.TeamDTO;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    @Setter
    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @Getter @Setter
    private Set<Developer> developers;

    public TeamDTO transformToDTO() {

        List<DeveloperDTO> devDTO = this.getDevelopers()
                .stream()
                .map(Developer::transformToDTO)
                .collect(Collectors.toList());

        TeamDTO dto = new TeamDTO(this.getId(), this.getName(), devDTO);

        return dto;
    }
}