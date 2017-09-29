package ch.raiffeisen.phong.springboot.demo.controller;

import ch.raiffeisen.phong.springboot.demo.dto.TeamDTO;
import ch.raiffeisen.phong.springboot.demo.dto.TeamNewUpdateDTO;
import ch.raiffeisen.phong.springboot.demo.mapper.TeamMapper;
import ch.raiffeisen.phong.springboot.demo.service.TeamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/team")
@Api(value="Team", description="Team")
public class TeamController {

    private TeamService teamService;
    private TeamMapper teamMapper = Mappers.getMapper(TeamMapper.class);


    @Autowired
    public void setTeamService(TeamService teamService){
        this.teamService = teamService;
    }

    @ApiOperation(value = "List all Teams",response = Iterable.class)
    @RequestMapping(value = "/list", method= RequestMethod.GET)
    public Iterable<TeamDTO> listTeams(){
        return  teamMapper.teamIterableToTeamDTOIterable(teamService.getAllTeams());

    }

    @ApiOperation(value = "Search a Team by Id",response = TeamDTO.class)
    @RequestMapping(value = "/showById/{id}", method= RequestMethod.GET, produces = "application/json")
    public TeamDTO showTeamById(@PathVariable Integer id){
        return teamMapper.teamToTeamDTO(teamService.getTeamById(id));
    }

/*    @ApiOperation(value = "Search a Team by Player Id",response = Team.class)
    @RequestMapping(value = "/showByPlayer/{id}", method= RequestMethod.GET, produces = "application/json")
    public Team showTeamByPlayerId(@PathVariable Integer id, Model model){
        return teamService.getTeamByPlayerId(id);
    }*/

    @ApiOperation(value = "Search a Team by Name",response = TeamDTO.class)
    @RequestMapping(value = "/showByName/{name}", method= RequestMethod.GET, produces = "application/json")
    public TeamDTO showTeamByName(@PathVariable String name){
        return teamMapper.teamToTeamDTO(teamService.getTeamByName(name));
    }

    @ApiOperation(value = "Add a Team")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity addTeam(@RequestBody TeamNewUpdateDTO teamNewDTO){
        teamService.saveTeam(teamMapper.teamNewUpdateDTOtoTeam(teamNewDTO));
        return new ResponseEntity("Team saved successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "Update a Team")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity updatePlayer(@PathVariable Integer id, @RequestBody TeamNewUpdateDTO teamNewUpdateDTO){
        teamService.updateTeam(id, teamMapper.teamNewUpdateDTOtoTeam(teamNewUpdateDTO));
        return new ResponseEntity("Player updated successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a Team")
    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity deleteTeam(@PathVariable Integer id){
        teamService.deleteTeam(id);
        return new ResponseEntity("Teams deleted successfully", HttpStatus.OK);

    }


}
