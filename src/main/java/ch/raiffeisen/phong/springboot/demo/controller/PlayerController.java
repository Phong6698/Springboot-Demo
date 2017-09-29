package ch.raiffeisen.phong.springboot.demo.controller;

import ch.raiffeisen.phong.springboot.demo.domain.Player;
import ch.raiffeisen.phong.springboot.demo.dto.PlayerNewDTO;
import ch.raiffeisen.phong.springboot.demo.mapper.PlayerMapper;
import ch.raiffeisen.phong.springboot.demo.service.PlayerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Model;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
@Api(value="Player", description="Player")
public class PlayerController {

    private PlayerService playerService;
    private PlayerMapper playerMapper = Mappers.getMapper(PlayerMapper.class);

    @Autowired
    public void setPlayerService(PlayerService playerService){
        this.playerService = playerService;
    }

    @ApiOperation(value = "List all Players",response = Iterable.class)
    @RequestMapping(value = "/list", method= RequestMethod.GET)
    public Iterable listPlayers(Model model){
        return  playerService.getAllPlayers();

    }

    @ApiOperation(value = "Search a Player by Id",response = Player.class)
    @RequestMapping(value = "/showById/{id}", method= RequestMethod.GET, produces = "application/json")
    public Player showPlayerById(@PathVariable Integer id, Model model){
        Player player = playerService.getPlayerById(id);
        return player;
    }

    @ApiOperation(value = "Search a Player by Email",response = Player.class)
    @RequestMapping(value = "/showByEmail/{email}", method= RequestMethod.GET, produces = "application/json")
    public Player showPlayerByEmail(@PathVariable String email, Model model){
        //TODO Problem mit @Zeichen
        Player player = playerService.getPlayerByEmail(email);
        return player;
    }

    @ApiOperation(value = "Search a Player by String",response = Iterable.class)
    @RequestMapping(value = "/search/{string}", method= RequestMethod.GET, produces = "application/json")
    public Iterable<Player> searchPlayer(@PathVariable String string, Model model){
        return playerService.searchPlayer(string);

    }

    @ApiOperation(value = "Add a Player")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity addPlayer(@RequestBody PlayerNewDTO playerNewDTO){
        playerService.savePlayer(playerMapper.playerNewDTOtoplayer(playerNewDTO));
        return new ResponseEntity("Player saved successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "Update a Player")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity updatePlayer(@PathVariable Integer id, @RequestBody Player player){
        playerService.updatePlayer(id, player);
        return new ResponseEntity("Player updated successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a Player")
    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity deletePlayer(@PathVariable Integer id){
        playerService.deletePlayer(id);
        return new ResponseEntity("Product deleted successfully", HttpStatus.OK);

    }
}
