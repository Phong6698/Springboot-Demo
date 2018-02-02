package ch.raiffeisen.phong.springboot.demo.service;

import ch.raiffeisen.phong.springboot.demo.domain.Player;
import ch.raiffeisen.phong.springboot.demo.domain.Team;
import ch.raiffeisen.phong.springboot.demo.repository.PlayerRepository;
import ch.raiffeisen.phong.springboot.demo.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TeamService {


    private TeamRepository teamRepository;
    private PlayerRepository playerRepository;

    @Autowired
    public void setTeamRepository(TeamRepository teamRepository, PlayerRepository playerRepository){
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
    }

    public Iterable<Team> getAllTeams(){
        return teamRepository.findAll();
    }

    public Team saveTeam(Team team){
        teamRepository.save(team);
        for(Player player : team.getPlayers()){
            Player playerDb = playerRepository.findOne(player.getId());
            playerDb.setTeam(team);
            playerRepository.save(playerDb);
        }
        return team;
    }

    public void deleteTeam(Integer id) {
        for(Player player : teamRepository.findOne(id).getPlayers()){
            player.setTeam(null);
        }
        teamRepository.delete(id);
    }

    public Team getTeamById(Integer id) {
        return teamRepository.findOne(id);
    }

    public Team getTeamByName(String name){
        return teamRepository.findByName(name);
    }
}
