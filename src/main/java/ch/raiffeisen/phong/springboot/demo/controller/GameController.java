package ch.raiffeisen.phong.springboot.demo.controller;

import ch.raiffeisen.phong.springboot.demo.domain.Game;
import ch.raiffeisen.phong.springboot.demo.dto.GameDTO;
import ch.raiffeisen.phong.springboot.demo.dto.GameNewDTO;
import ch.raiffeisen.phong.springboot.demo.dto.GamePlayedDTO;
import ch.raiffeisen.phong.springboot.demo.dto.GameUnplayedDTO;
import ch.raiffeisen.phong.springboot.demo.mapper.GameMapper;
import ch.raiffeisen.phong.springboot.demo.service.GameService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
@Api(value="Game", description="Game")
public class GameController {

    private GameService gameService;
    private GameMapper gameMapper = Mappers.getMapper(GameMapper.class);

    @Autowired
    public void setGameService(GameService gameService){
        this.gameService = gameService;
    }

    @ApiOperation(value = "List played games",response = Iterable.class)
    @RequestMapping(value = "/listPlayedGames", method= RequestMethod.GET)
    public Iterable<GamePlayedDTO> listPlayedGames(){
        return gameMapper.gameIterableToGamePlayedDTOIterable(gameService.getPlayedGames());

    }

    @ApiOperation(value = "List unplayed games",response = Iterable.class)
    @RequestMapping(value = "/listUnplayedGames", method= RequestMethod.GET)
    public Iterable<GameUnplayedDTO> listUnplayedGames(){
        return gameMapper.gameIterableToGameUnplayedDTOIterable(gameService.getUnplayedGames());

    }

    @ApiOperation(value = "Add a new Game")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity addGame(@RequestBody GameNewDTO gameNewDTO){
        gameService.saveNewGame(gameMapper.gameNewDTOtoGame(gameNewDTO));
        return new ResponseEntity("Game saved successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "Show Game by id",response = GameDTO.class)
    @RequestMapping(value = "/show/{id}", method= RequestMethod.GET, produces = "application/json")
    public GameDTO showGameById(@PathVariable Integer id){
        return gameMapper.gamtToGameDTO(gameService.getGameById(id));
    }

    @ApiOperation(value = "Update a Game")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity updateGame(@PathVariable Integer id, @RequestBody GameDTO gameDTO){
        gameService.updateGame(id, gameMapper.gameDTOtoGame(gameDTO));
        return new ResponseEntity("Game updated successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a Game")
    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity deleteGame(@PathVariable Integer id){
        gameService.deleteGame(id);
        return new ResponseEntity("Game deleted successfully", HttpStatus.OK);

    }


}
