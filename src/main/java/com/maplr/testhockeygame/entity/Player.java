package com.maplr.testhockeygame.entity;


import javax.persistence.*;

@Entity
public class Player {

    @Id
    @GeneratedValue
    private Long id;
    private Long number;
    private String name;
    private String lastname;
    private String position;
    private Boolean isCaptain;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Team team;

    public Player() {
    }

    public Player(Long number, String name, String lastname, String position, Boolean isCaptain, Team team) {
        this.number = number;
        this.name = name;
        this.lastname = lastname;
        this.position = position;
        this.isCaptain = isCaptain;
        this.team = team;
    }

    public static Player of(Long number, String name, String lastname, String position, Boolean isCaptain, Team team) {
        return new Player(number, name, lastname, position, isCaptain, team);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Boolean isCaptain() {
        return isCaptain;
    }

    public void setCaptain(Boolean captain) {
        isCaptain = captain;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

}
