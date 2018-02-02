package ch.raiffeisen.phong.springboot.demo.controller;

import ch.raiffeisen.phong.springboot.demo.domain.Player;
import ch.raiffeisen.phong.springboot.demo.dto.PlayerDTO;
import ch.raiffeisen.phong.springboot.demo.mapper.PlayerMapper;
import ch.raiffeisen.phong.springboot.demo.service.PlayerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
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
    public Iterable<PlayerDTO> listPlayers(){
        return  playerMapper.playerIterableToPlayerDTOIterable(playerService.getAllPlayers());

    }

    @ApiOperation(value = "Search a Player by Id",response = PlayerDTO.class)
    @RequestMapping(value = "/showById/{id}", method= RequestMethod.GET, produces = "application/json")
    public PlayerDTO showPlayerById(@PathVariable Integer id){
        return playerMapper.playerToPlayerDTO(playerService.getPlayerById(id));
    }

    @ApiOperation(value = "Search a Player by Email",response = PlayerDTO.class)
    @RequestMapping(value = "/showByEmail/{email}", method= RequestMethod.GET, produces = "application/json")
    public PlayerDTO showPlayerByEmail(@PathVariable String email){
        //TODO Problem mit @Zeichen
        return playerMapper.playerToPlayerDTO(playerService.getPlayerByEmail(email));
    }

    @ApiOperation(value = "Search a Player by String",response = Iterable.class)
    @RequestMapping(value = "/search/{string}", method= RequestMethod.GET, produces = "application/json")
    public Iterable<PlayerDTO> searchPlayer(@PathVariable String string){
        return playerMapper.playerIterableToPlayerDTOIterable(playerService.searchPlayer(string));

    }

    @ApiOperation(value = "Add a Player")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity addPlayer(@RequestBody PlayerDTO playerDTO){
        Player player = playerService.savePlayer(playerMapper.playerDTOtoPlayer(playerDTO));
        return new ResponseEntity(playerMapper.playerToPlayerDTO(player), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update a Player")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity updatePlayer(@RequestBody PlayerDTO playerDTO){
        Player player = playerService.savePlayer(playerMapper.playerDTOtoPlayer(playerDTO));
        return new ResponseEntity(playerMapper.playerToPlayerDTO(player), HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a Player")
    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity deletePlayer(@PathVariable Integer id){
        playerService.deletePlayer(id);
        return new ResponseEntity("Product deleted successfully", HttpStatus.OK);

    }
}
