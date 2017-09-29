package ch.raiffeisen.phong.springboot.demo.service;

import ch.raiffeisen.phong.springboot.demo.domain.TeamGame;
import ch.raiffeisen.phong.springboot.demo.repository.TeamGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamGameService {

    private TeamGameRepository teamGameRepository;

    @Autowired
    public void setTeamGameRepository(TeamGameRepository teamGameRepository){
        this.teamGameRepository = teamGameRepository;
    }

    public Iterable<TeamGame> getAllTeamGames(){
        return teamGameRepository.findAll();
    }

    public void saveTeamGame(TeamGame teamGame){
        teamGameRepository.save(teamGame);
    }

    public void deleteTeamGame(Integer id) {
        teamGameRepository.delete(id);
    }
}
