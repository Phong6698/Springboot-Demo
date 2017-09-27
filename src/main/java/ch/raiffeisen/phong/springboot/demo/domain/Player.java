package ch.raiffeisen.phong.springboot.demo.domain;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "Player.getAllPlayers", query = "SELECT p FROM Player p"),
})
@Entity
@Table(name="PLAYER")
public class Player {

    @Id
    @GeneratedValue
    private int id;

    @Column(name="First_Name")
    private String firstName;

    @Column(name="Last_Name")
    private String lastName;

    @Column(name="Email")
    private String email;

    @ManyToOne
    @JoinColumn(name="Team_ID")
    private Team team;

    public Player(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Player() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
