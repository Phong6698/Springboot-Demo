package ch.raiffeisen.phong.springboot.demo.dto;

import java.util.Date;
import java.util.List;

public class GamePlayedDTO {

    private int id;
    private Date timePlayed;
    private List<TeamGameDTO> teamGames;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTimePlayed() {
        return timePlayed;
    }

    public void setTimePlayed(Date timePlayed) {
        this.timePlayed = timePlayed;
    }

    public List<TeamGameDTO> getTeamGames() {
        return teamGames;
    }

    public void setTeamGames(List<TeamGameDTO> teamGames) {
        this.teamGames = teamGames;
    }
}
