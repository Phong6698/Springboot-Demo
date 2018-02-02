package ch.raiffeisen.phong.springboot.demo.service;

import ch.raiffeisen.phong.springboot.demo.domain.Player;
import ch.raiffeisen.phong.springboot.demo.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private PlayerRepository playerRepository;

    @Autowired
    public void setPlayerRepository(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    public Iterable<Player> getAllPlayers(){
        return playerRepository.findAll();
    }

    public Player savePlayer(Player player){
        return playerRepository.save(player);
    }

    public void deletePlayer(Integer id) {
        playerRepository.delete(id);
    }

    public Player getPlayerById(Integer id) {
        return playerRepository.findOne(id);
    }

    public Player getPlayerByEmail(String email){
        return playerRepository.findByEmail(email);
    }

    public Iterable<Player> searchPlayer(String string){
        return playerRepository.findAllByFirstNameContainsOrLastNameContainsOrEmailContains(string, string, string);
    }
}
