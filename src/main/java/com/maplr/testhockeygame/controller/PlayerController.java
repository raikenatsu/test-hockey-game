package com.maplr.testhockeygame.controller;

import com.maplr.testhockeygame.dto.PlayerDTO;
import com.maplr.testhockeygame.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/player", produces = {"application/json"})
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PutMapping(value = "/captain/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PlayerDTO> makeCaptain(@PathVariable(name = "id") Long playerId) {
        return ResponseEntity.ok(playerService.makeCaptain(playerId));
    }

}
