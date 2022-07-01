package com.maplr.testhockeygame.service;

import com.maplr.testhockeygame.dto.PlayerDTO;
import com.maplr.testhockeygame.entity.Player;
import com.maplr.testhockeygame.exception.PlayerNotFoundException;
import com.maplr.testhockeygame.factory.PlayerFactory;
import com.maplr.testhockeygame.repository.PlayerRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public PlayerDTO makeCaptain(Long playerId) throws PlayerNotFoundException {
        Player player = playerRepository.findById(playerId).orElseThrow(PlayerNotFoundException::new);
        if (Boolean.TRUE.equals(player.isCaptain())) {
            return PlayerFactory.convert(player);
        }

        // Find if player's team have already has a captain and dismiss him
        playerRepository.findAllByTeamAndIsCaptain(player.getTeam(), true).ifPresent(p -> {
            p.setCaptain(null);
            playerRepository.save(p);
        });

        player.setCaptain(true);
        playerRepository.save(player);
        return PlayerFactory.convert(player);
    }

}
