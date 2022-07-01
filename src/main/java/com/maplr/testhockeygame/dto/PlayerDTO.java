package com.maplr.testhockeygame.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlayerDTO {

    private final Long id;
    private final Long number;
    private final String name;
    private final String lastname;
    private final String position;
    private final Boolean isCaptain;

    public PlayerDTO(Long id, Long number, String name, String lastname, String position, Boolean isCaptain) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.lastname = lastname;
        this.position = position;
        this.isCaptain = isCaptain;
    }

    public static PlayerDTO of(Long id, Long number, String name, String lastname, String position, Boolean isCaptain) {
        return new PlayerDTO(id, number, name, lastname, position, isCaptain);
    }

    public Long getId() {
        return id;
    }

    public Long getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPosition() {
        return position;
    }

    @JsonProperty("isCaptain")
    public Boolean isCaptain() {
        return isCaptain;
    }

}
