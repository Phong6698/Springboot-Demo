package ch.raiffeisen.phong.springboot.demo.domain;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "TeamGame.getAllTeamGames", query = "SELECT tg FROM TeamGame tg"),
})
@Entity
@Table(name="TEAM_GAME")
public class TeamGame {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name="Game_ID")
    private Game game;

    @ManyToOne
    @JoinColumn(name="Team_ID")
    private Team team;

    @Column(name="Score")
    private int score;

    @Column(name="Is_Winner")
    private boolean isWinner;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean isWinner) {
        isWinner = isWinner;
    }

}