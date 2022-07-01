package com.maplr.testhockeygame.service;

import com.maplr.testhockeygame.dto.PlayerDTO;
import com.maplr.testhockeygame.dto.TeamDTO;
import com.maplr.testhockeygame.entity.Player;
import com.maplr.testhockeygame.entity.Team;
import com.maplr.testhockeygame.exception.PlayerNumberAlreadyExistsException;
import com.maplr.testhockeygame.exception.TeamNotFoundException;
import com.maplr.testhockeygame.factory.PlayerFactory;
import com.maplr.testhockeygame.factory.TeamFactory;
import com.maplr.testhockeygame.repository.PlayerRepository;
import com.maplr.testhockeygame.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;

    public TeamService(TeamRepository teamRepository, PlayerRepository playerRepository) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
    }

    public TeamDTO getTeamByYear(Long year) throws TeamNotFoundException {
        return teamRepository.findByYear(year).map(TeamFactory::convert).orElseThrow(TeamNotFoundException::new);
    }

    public PlayerDTO addPlayerToTeam(PlayerDTO playerDTO, Long year) throws PlayerNumberAlreadyExistsException {
        // Find existing team or create it
        Team team = teamRepository.findByYear(year).orElseGet(() -> teamRepository.save(Team.of(year)));

        // If player have same number in team throw exception
        if (team.getPlayers().stream().anyMatch(p -> playerDTO.getNumber().equals(p.getNumber()))) {
            throw new PlayerNumberAlreadyExistsException();
        }

        // If new player is captain check and dismiss actual captain
        if (Boolean.TRUE.equals(playerDTO.isCaptain())) {
            team.setPlayers(
                team.getPlayers().stream().map(p -> {
                    if (Boolean.TRUE.equals(p.isCaptain())) {
                        p.setCaptain(null);
                    }
                    return p;
                }).collect(Collectors.toList())
            );
            teamRepository.save(team);
        }

        Player player = Player.of(
            playerDTO.getNumber(), playerDTO.getName(), playerDTO.getLastname(), playerDTO.getPosition(),
            playerDTO.isCaptain(), team
        );
        playerRepository.save(player);
        return PlayerFactory.convert(player);
    }

}
