package ch.raiffeisen.phong.springboot.demo.service;



import ch.raiffeisen.phong.springboot.demo.domain.Player;
import ch.raiffeisen.phong.springboot.demo.domain.Team;
import ch.raiffeisen.phong.springboot.demo.repository.PlayerRepository;
import ch.raiffeisen.phong.springboot.demo.repository.TeamRepository;

import java.util.ArrayList;
import java.util.List;

public class TeamService {


    private TeamRepository teamRepository;
    private PlayerRepository playerRepository;


    public TeamService(TeamRepository teamRepository, PlayerRepository playerRepository) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
    }

    public List<Team> getAllTeams(){
        return teamRepository.getAllTeams();
    }

    public void createTeamWithPlayers(String name, int player1Id, int player2Id){
        Team team = new Team(name);
        teamRepository.addTeam(team);

        Player player1 = playerRepository.getPlayerById(player1Id);
        player1.setTeam(team);
        playerRepository.updatePlayer(player1);

        Player player2 = playerRepository.getPlayerById(player2Id);
        player2.setTeam(team);
        playerRepository.updatePlayer(player2);

        //Nicht sehr schön. Bei Aufrufung in der Main ist es sonst nicht im Team.
        List<Player> players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);

        team.setPlayers(players);

    }
}
