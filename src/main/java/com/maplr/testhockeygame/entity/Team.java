package com.maplr.testhockeygame.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue
    private Long id;
    private String coach;
    private Long year;
    @OneToMany(mappedBy = "team")
    private List<Player> players = new ArrayList<>();

    public Team() {
    }

    public Team(Long id, String coach, Long year, List<Player> players) {
        this.id = id;
        this.coach = coach;
        this.year = year;
        this.players = players;
    }

    public static Team of(String coach, Long year) {
        return new Team(null, coach, year, null);
    }

    public static Team of(Long year) {
        return new Team(null, null, year, new ArrayList<>());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

}
