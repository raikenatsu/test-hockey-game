package com.maplr.testhockeygame.factory;

import com.maplr.testhockeygame.dto.TeamDTO;
import com.maplr.testhockeygame.entity.Team;

public class TeamFactory {

    private TeamFactory() {
    }

    public static TeamDTO convert(Team team) {
        return team == null ? null : TeamDTO.of(
            team.getId(), team.getCoach(), team.getYear(), PlayerFactory.convert(team.getPlayers())
        );
    }

}
