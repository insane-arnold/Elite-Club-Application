package com.club.eliteclub.entity;

import jakarta.persistence.*;


import java.io.Serializable;
@Entity
@Table(name="EliteCLub")
public class EliteClub implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name="ClubName")
    private String clubName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }
}
