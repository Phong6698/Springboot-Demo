package ch.raiffeisen.phong.springboot.demo.domain;

import javax.persistence.*;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = "Team.getAllTeams", query = "SELECT t FROM Team t"),
})
@Entity
@Table(name="TEAM")
public class Team {

    @Id
    @GeneratedValue
    private int id;

    @Column(name="Name")
    private String name;

    @OneToMany(mappedBy="team")
    private List<Player> players;

    @OneToMany(mappedBy="team")
    private List<TeamGame> teamGames;

    public Team(String name) {
        this.name = name;
    }

    public Team() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<TeamGame> getTeamGames() {
        return teamGames;
    }

    public void setTeamGames(List<TeamGame> teamGames) {
        this.teamGames = teamGames;
    }
}
