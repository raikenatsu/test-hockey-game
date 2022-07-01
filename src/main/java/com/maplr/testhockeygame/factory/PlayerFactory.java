package com.maplr.testhockeygame.factory;

import com.maplr.testhockeygame.dto.PlayerDTO;
import com.maplr.testhockeygame.entity.Player;

import java.util.List;
import java.util.stream.Collectors;

public class PlayerFactory {

    private PlayerFactory() {
    }

    public static PlayerDTO convert(Player player) {
        return player == null ? null : PlayerDTO.of(
            player.getId(), player.getNumber(), player.getName(), player.getLastname(), player.getPosition(), player.isCaptain()
        );
    }

    public static List<PlayerDTO> convert(List<Player> players) {
        return players == null ? null : players.stream().map(PlayerFactory::convert).collect(Collectors.toList());
    }

}
