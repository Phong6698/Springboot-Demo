package ch.raiffeisen.phong.springboot.demo.dto;

import java.util.Date;
import java.util.List;

public class GameDTO {

    private int id;
    private Date timePlaned;
    private Date timePlayed;
    private List<TeamGameDTO> teamGames;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTimePlaned() {
        return timePlaned;
    }

    public void setTimePlaned(Date timePlaned) {
        this.timePlaned = timePlaned;
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
