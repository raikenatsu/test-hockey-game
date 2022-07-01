package com.maplr.testhockeygame.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeamDTO {

    private final Long id;
    private final String coach;
    private final Long year;
    private final List<PlayerDTO> players;

    public TeamDTO(Long id, String coach, Long year, List<PlayerDTO> players) {
        this.id = id;
        this.coach = coach;
        this.year = year;
        this.players = players;
    }

    public static TeamDTO of (Long id, String coach, Long year, List<PlayerDTO> players) {
        return new TeamDTO(id, coach, year, players);
    }

    public Long getId() {
        return id;
    }

    public String getCoach() {
        return coach;
    }

    public Long getYear() {
        return year;
    }

    public List<PlayerDTO> getPlayers() {
        return players;
    }

}
