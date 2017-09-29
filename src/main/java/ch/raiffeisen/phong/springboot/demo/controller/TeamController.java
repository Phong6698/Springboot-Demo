package ch.raiffeisen.phong.springboot.demo.controller;

import ch.raiffeisen.phong.springboot.demo.domain.Team;
import ch.raiffeisen.phong.springboot.demo.service.TeamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/team")
@Api(value="Team", description="Team")
public class TeamController {

    private TeamService teamService;


    @Autowired
    public void setTeamService(TeamService teamService){
        this.teamService = teamService;
    }

    @ApiOperation(value = "List all Teams",response = Iterable.class)
    @RequestMapping(value = "/list", method= RequestMethod.GET)
    public Iterable listTeams(Model model){
        return  teamService.getAllTeams();

    }

    @ApiOperation(value = "Search a Team by Id",response = Team.class)
    @RequestMapping(value = "/showById/{id}", method= RequestMethod.GET, produces = "application/json")
    public Team showTeamById(@PathVariable Integer id, Model model){
        return teamService.getTeamById(id);
    }

/*    @ApiOperation(value = "Search a Team by Player Id",response = Team.class)
    @RequestMapping(value = "/showByPlayer/{id}", method= RequestMethod.GET, produces = "application/json")
    public Team showTeamByPlayerId(@PathVariable Integer id, Model model){
        return teamService.getTeamByPlayerId(id);
    }*/

    @ApiOperation(value = "Search a Team by Name",response = Team.class)
    @RequestMapping(value = "/showByName/{name}", method= RequestMethod.GET, produces = "application/json")
    public Team showTeamByName(@PathVariable String name, Model model){
        return teamService.getTeamByName(name);
    }

    @ApiOperation(value = "Add a Team")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity addTeam(@RequestBody Team team){
        teamService.saveTeam(team);
        return new ResponseEntity("Team saved successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a Team")
    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity deleteTeam(@PathVariable Integer id){
        teamService.deleteTeam(id);
        return new ResponseEntity("Teams deleted successfully", HttpStatus.OK);

    }


}
