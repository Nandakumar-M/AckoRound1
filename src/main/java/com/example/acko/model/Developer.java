package com.example.acko.model;

import com.example.acko.dtos.DeveloperDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(nullable = false)
    @Getter @Setter
    private String name;

    @Column(nullable = false)
    @Getter @Setter
    private String phoneNo;

    @ManyToOne(optional = false)
    @Column(nullable = false)
    @Getter @Setter
    private Team team;

    public DeveloperDTO transformToDTO() {
        return new DeveloperDTO(this.getId(), this.getName(), this.getPhoneNo());
    }
}
