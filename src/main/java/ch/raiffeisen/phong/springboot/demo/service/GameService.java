package ch.raiffeisen.phong.springboot.demo.service;


import ch.raiffeisen.phong.springboot.demo.domain.Game;
import ch.raiffeisen.phong.springboot.demo.domain.TeamGame;
import ch.raiffeisen.phong.springboot.demo.repository.GameRepository;
import ch.raiffeisen.phong.springboot.demo.repository.TeamGameRepository;
import ch.raiffeisen.phong.springboot.demo.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class GameService {

    private GameRepository gameRepository;
    private TeamGameRepository teamGameRepository;
    private TeamRepository teamRepository;

    @Autowired
    public void setGameRepository(GameRepository gameRepository, TeamGameRepository teamGameRepository, TeamRepository teamRepository){
        this.gameRepository = gameRepository;
        this.teamGameRepository = teamGameRepository;
        this.teamRepository = teamRepository;
    }

    public void saveNewGame(Game game){
        gameRepository.save(game);
        for(TeamGame teamGame : game.getTeamGames()){
            teamGame.setGame(game);
        }
        teamGameRepository.save(game.getTeamGames());
        //TODO Gibt es eine andere möglichkeit?
    }

    public Game getGameById(Integer id){
        return gameRepository.findOne(id);
    }


    public void deleteGame(Integer id) {
        teamGameRepository.delete(gameRepository.findOne(id).getTeamGames());
        gameRepository.delete(id);
    }


    public Iterable<Game> getPlayedGames() {
        return gameRepository.findAllByTimePlayedIsNotNullOrderByTimePlayedDesc();
    }

    public Iterable<Game> getUnplayedGames(){
        return gameRepository.findAllByTimePlayedIsNullOrderByTimePlanedAsc();
    }

    public void updateGame(Integer id, Game game) {
        for(TeamGame teamGame : game.getTeamGames()){
            TeamGame dbTeamGame = teamGameRepository.findOne(teamGame.getId());
            dbTeamGame.setScore(teamGame.getScore());
            dbTeamGame.setWinner(teamGame.isWinner());
            teamGameRepository.save(dbTeamGame);
        }
        Game dbGame = gameRepository.findOne(id);
        dbGame.setTimePlayed(new Date());
        gameRepository.save(dbGame);
        //TODO Gibt es eine andere möglichkeit?
    }

    public Iterable<Game> getGamesByTeamId(Integer id){
        List<Integer> gamesIds = new ArrayList<Integer>();
        for(TeamGame teamGame : teamRepository.findOne(id).getTeamGames()){
            gamesIds.add(teamGame.getGame().getId());
        }
        return gameRepository.findAll(gamesIds);
    }
}
