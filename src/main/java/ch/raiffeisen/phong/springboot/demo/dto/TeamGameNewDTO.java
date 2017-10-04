package ch.raiffeisen.phong.springboot.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class TeamGameNewDTO {

    private int teamId;
/*
    @JsonIgnore
    private int gameId;*/

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

/*    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }*/
}
