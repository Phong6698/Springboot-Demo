package ch.raiffeisen.phong.springboot.demo.service;


import ch.raiffeisen.phong.springboot.demo.domain.Game;
import ch.raiffeisen.phong.springboot.demo.repository.GameRepository;
import ch.raiffeisen.phong.springboot.demo.repository.TeamGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private GameRepository gameRepository;

    @Autowired
    public void setGameRepository(GameRepository gameRepository){
        this.gameRepository = gameRepository;
    }

    public Iterable<Game> getAllGames(){
        return gameRepository.findAll();
    }

    public void saveGame(Game game){
        gameRepository.save(game);
    }

    public void deleteGame(Integer id) {
        gameRepository.delete(id);
    }


}
