package ch.raiffeisen.phong.springboot.demo.service;

import ch.raiffeisen.phong.springboot.demo.domain.Team;
import ch.raiffeisen.phong.springboot.demo.repository.PlayerRepository;
import ch.raiffeisen.phong.springboot.demo.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TeamService {


    private TeamRepository teamRepository;

    @Autowired
    public void setTeamRepository(TeamRepository teamRepository){
        this.teamRepository = teamRepository;
    }

    public Iterable<Team> getAllTeams(){
        return teamRepository.findAll();
    }

    public void saveTeam(Team team){
        teamRepository.save(team);
    }

    public void deleteTeam(Integer id) {
        teamRepository.delete(id);
    }

    public Team getTeamById(Integer id) {
        return teamRepository.findOne(id);
    }

/*    public Team getTeamByPlayerId(Integer id) {
        return teamRepository.findByPlayers(id);
    }*/

    public Team getTeamByName(String name){
        return teamRepository.findByName(name);
    }

    public void updateTeam(Integer id, Team team) {
        Team storedTeam = teamRepository.findOne(id);
        storedTeam.setName(team.getName());
        teamRepository.save(storedTeam);
    }
}
