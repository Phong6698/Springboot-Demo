package ch.raiffeisen.phong.springboot.demo.dto;

import java.util.List;

public class TeamDTO {

    private int id;
    private String name;
    private List<PlayerDTO> players;

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

    public List<PlayerDTO> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerDTO> players) {
        this.players = players;
    }
}
