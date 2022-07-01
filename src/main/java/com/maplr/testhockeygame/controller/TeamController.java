package com.maplr.testhockeygame.controller;

import com.maplr.testhockeygame.dto.PlayerDTO;
import com.maplr.testhockeygame.dto.TeamDTO;
import com.maplr.testhockeygame.service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Map;

@RestController
@RequestMapping(value = "/team", produces = {"application/json"})
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping(value = "/{year}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<TeamDTO> getTeamByYear(@PathVariable(name = "year") Long year) {
        return ResponseEntity.ok(teamService.getTeamByYear(year));
    }

    @PostMapping(value = "/{year}", consumes = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PlayerDTO> addPlayerToTeam(@PathVariable(name = "year") Long year, @RequestBody PlayerDTO player) {
        return ResponseEntity.created(
            ServletUriComponentsBuilder.fromCurrentRequest().build(Map.of("year", year))
        ).body(teamService.addPlayerToTeam(player, year));
    }

}
