package ch.raiffeisen.phong.springboot.demo.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="GAME")
public class Game {

    @Id
    @GeneratedValue
    private int id;

    @Column(name="Time_Planed")
    private Date timePlaned;

    @Column(name="Time_Played")
    private Date timePlayed;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    private List<TeamGame> teamGames;

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

    public List<TeamGame> getTeamGames() {
        return teamGames;
    }

    public void setTeamGames(List<TeamGame> teamGames) {
        this.teamGames = teamGames;
    }
}
