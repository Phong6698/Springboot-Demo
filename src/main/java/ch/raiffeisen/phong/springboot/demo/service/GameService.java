package ch.raiffeisen.phong.springboot.demo.service;


import ch.raiffeisen.phong.springboot.demo.domain.Game;
import ch.raiffeisen.phong.springboot.demo.domain.Team;
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

    public Iterable<Game> getPlayedGamesByTeamId(Integer teamId){
        List<Integer> gamesIds = new ArrayList<Integer>();
        Team team = teamRepository.findOne(teamId);
        if(team == null) {
            return null;
        }else{
            List<TeamGame> teamGames = team.getTeamGames();
            if(teamGames.size() == 0) {
                return null;
            }else{
                for (TeamGame teamGame : teamGames) {
                    gamesIds.add(teamGame.getGame().getId());
                }
                return gameRepository.findAllByTimePlayedIsNotNullAndIdInOrderByTimePlayedDesc(gamesIds);
            }
        }
    }

    public Iterable<Game> getUnplayedGames(){
        return gameRepository.findAllByTimePlayedIsNullOrderByTimePlanedAsc();
    }
    public Iterable<Game> getUnplayedGamesByTeamId(Integer teamId) {
        List<Integer> gamesIds = new ArrayList<Integer>();
        Team team = teamRepository.findOne(teamId);
        if(team == null) {
            return null;
        }else{
            List<TeamGame> teamGames = team.getTeamGames();
            if(teamGames.size() == 0) {
                return null;
            }else{
                for (TeamGame teamGame : teamGames) {
                    gamesIds.add(teamGame.getGame().getId());
                }
                return gameRepository.findAllByTimePlayedIsNullAndIdInOrderByTimePlanedAsc(gamesIds);
            }
        }
    }


    public Iterable<Game> getGames() {
        return gameRepository.findAll();

    }

    public Iterable<Game> getGamesByTeamId(Integer teamId){
        List<Integer> gamesIds = new ArrayList<Integer>();
        Team team = teamRepository.findOne(teamId);
        if(team == null) {
            return null;
        }else{
            List<TeamGame> teamGames = team.getTeamGames();
            if(teamGames.size() == 0) {
                return null;
            }else{
                for (TeamGame teamGame : teamGames) {
                    gamesIds.add(teamGame.getGame().getId());
                }
                return gameRepository.findAll(gamesIds);
            }
        }
    }

    public Game saveGame(Game game) {
        for(TeamGame teamGame : game.getTeamGames()){
            teamGame.setGame(game);
        }
        return gameRepository.save(game);
    }

}
