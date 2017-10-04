package ch.raiffeisen.phong.springboot.demo.dto;

import java.util.Date;
import java.util.List;

public class GameNewDTO {

    private Date timePlaned;
    private List<TeamGameNewDTO> teamGames;

    public Date getTimePlaned() {
        return timePlaned;
    }

    public void setTimePlaned(Date timePlaned) {
        this.timePlaned = timePlaned;
    }

    public List<TeamGameNewDTO> getTeamGames() {
        return teamGames;
    }

    public void setTeamGames(List<TeamGameNewDTO> teamGames) {
        this.teamGames = teamGames;
    }
}
