package ch.raiffeisen.phong.springboot.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="TEAM")
public class Team {

    @Id
    @GeneratedValue
    private int id;

    @Column(name="Name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy="team")
    private List<Player> players;

    @JsonIgnore
    @OneToMany(mappedBy="team")
    private List<TeamGame> teamGames;

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
