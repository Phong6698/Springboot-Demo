package ch.raiffeisen.phong.springboot.demo.service;

import rch.raiffeisen.phong.wm.domain.Game;
import rch.raiffeisen.phong.wm.repository.GameRepository;
import rch.raiffeisen.phong.wm.repository.TeamGameRepository;

import java.util.List;

public class GameService {

    private GameRepository gameRepository;
    private TeamGameRepository teamGameRepository;

    public GameService(GameRepository gameRepository, TeamGameRepository teamGameRepository) {
        this.gameRepository = gameRepository;
        this.teamGameRepository = teamGameRepository;
    }

    public List<Game> getAllUnplayedGames(){
        return gameRepository.getAllUnplayedGames();
    }

    public List<Game> getAllPlayedGames(){
        return gameRepository.getAllPlayedGames();
    }



}
