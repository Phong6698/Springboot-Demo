package ch.raiffeisen.phong.springboot.demo.service;

import rch.raiffeisen.phong.wm.domain.Player;
import rch.raiffeisen.phong.wm.repository.PlayerRepository;

import java.util.List;

public class PlayerService {

    private PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getAllPlayers(){
        return playerRepository.getAllPlayers();
    }

    public void createPlayer(String firstName, String lastName, String email){
        playerRepository.addPlayer(new Player(firstName,lastName,email));
    }

    public void updatePlayer(Player player){
        playerRepository.updatePlayer(player);
    }
}
