package ch.raiffeisen.phong.springboot.demo.dto;

import java.util.Date;
import java.util.List;

public class GameUnplayedDTO {

    private int id;
    private Date timePlaned;
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

    public List<TeamGameDTO> getTeamGames() {
        return teamGames;
    }

    public void setTeamGames(List<TeamGameDTO> teamGames) {
        this.teamGames = teamGames;
    }
}
