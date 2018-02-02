package ch.raiffeisen.phong.springboot.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name="PLAYER")
public class Player {

    @Id
    @GeneratedValue
    @ApiModelProperty(notes = "The database generated product ID")
    private int id;

    @Column(name="First_Name")
    @ApiModelProperty(notes = "The player First Name")
    private String firstName;

    @Column(name="Last_Name")
    @ApiModelProperty(notes = "The player First Name")
    private String lastName;

    @Column(name="Email")
    @ApiModelProperty(notes = "The player E-Mail")
    private String email;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="Team_ID")
    private Team team;

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
