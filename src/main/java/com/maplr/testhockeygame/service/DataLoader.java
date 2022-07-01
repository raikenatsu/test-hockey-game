package com.maplr.testhockeygame.service;

import com.maplr.testhockeygame.entity.Player;
import com.maplr.testhockeygame.entity.Team;
import com.maplr.testhockeygame.repository.PlayerRepository;
import com.maplr.testhockeygame.repository.TeamRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;

    public DataLoader(TeamRepository teamRepository, PlayerRepository playerRepository) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
    }

    public void run(ApplicationArguments args) {
        Team team2019 = Team.of("Dominique Ducharme", 2019L);
        Team team2020 = Team.of("Dominique Ducharme", 2020L);
        teamRepository.saveAll(List.of(team2019, team2020));
        playerRepository.saveAll(List.of(
            Player.of(31L, "Carey", "Price", "goaltender", null, team2019),
            Player.of(14L, "Nick", "Suzuki", "forward", null, team2019),
            Player.of(15L, "Jesperi", "Kotkaniemi", "forward", null, team2019),
            Player.of(71L, "Jake", "Evans", "forward", null, team2019),
            Player.of(27L, "Alexander", "Romanov", "defenseman", null, team2019),
            Player.of(6L, "Shea", "Weber", "defenseman", true, team2019),

            Player.of(31L, "Carey", "Price", "goaltender", null, team2020),
            Player.of(14L, "Nick", "Suzuki", "forward", null, team2020),
            Player.of(15L, "Jesperi", "Kotkaniemi", "forward", null, team2020),
            Player.of(71L, "Jake", "Evans", "forward", null, team2020),
            Player.of(27L, "Alexander", "Romanov", "defenseman", null, team2020),
            Player.of(6L, "Shea", "Weber", "defenseman", true, team2020)
        ));
    }

}
