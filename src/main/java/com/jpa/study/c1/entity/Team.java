package com.jpa.study.c1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Team {

    @Id
    @Column(name="TEAM_ID")
    private String id;

    private String name;

}
