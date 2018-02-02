package ch.raiffeisen.phong.springboot.demo.controller;

import ch.raiffeisen.phong.springboot.demo.domain.Game;
import ch.raiffeisen.phong.springboot.demo.dto.GameDTO;
import ch.raiffeisen.phong.springboot.demo.mapper.GameMapper;
import ch.raiffeisen.phong.springboot.demo.service.GameService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin // https://github.com/angular/angular/issues/6583
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
    public Iterable<GameDTO> listPlayedGames(@RequestParam(value = "teamId", required = false) Integer teamId){
        if(teamId == null){
            return gameMapper.gameIterableToGameDTOIterable(gameService.getPlayedGames());
        }else{
            return gameMapper.gameIterableToGameDTOIterable(gameService.getPlayedGamesByTeamId(teamId));
        }
    }

    @ApiOperation(value = "List unplayed games",response = Iterable.class)
    @RequestMapping(value = "/listUnplayedGames", method= RequestMethod.GET)
    public Iterable<GameDTO> listUnplayedGames(@RequestParam(value = "teamId", required = false) Integer teamId){
        if(teamId == null){
            return gameMapper.gameIterableToGameDTOIterable(gameService.getUnplayedGames());
        }else{
            return gameMapper.gameIterableToGameDTOIterable(gameService.getUnplayedGamesByTeamId(teamId));
        }
    }

    @ApiOperation(value = "List all games",response = Iterable.class)
    @RequestMapping(value = "/list", method= RequestMethod.GET)
    public Iterable<GameDTO> listGames(@RequestParam(value = "teamId", required = false) Integer teamId){
        if(teamId == null){
            return gameMapper.gameIterableToGameDTOIterable(gameService.getGames());
        }else{
            return gameMapper.gameIterableToGameDTOIterable(gameService.getGamesByTeamId(teamId));
        }
    }

    @ApiOperation(value = "Add a new Game")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity addGame(@RequestBody GameDTO gameDTO){
        Game game = gameService.saveGame(gameMapper.gameDTOtoGame(gameDTO));
        return new ResponseEntity(gameMapper.gameToGameDTO(game), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Show Game by id",response = GameDTO.class)
    @RequestMapping(value = "/show/{id}", method= RequestMethod.GET, produces = "application/json")
    public GameDTO showGameById(@PathVariable Integer id){
        return gameMapper.gameToGameDTO(gameService.getGameById(id));
    }

    @ApiOperation(value = "Update a Game")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity updateGame(@RequestBody GameDTO gameDTO){
        Game game = gameService.saveGame(gameMapper.gameDTOtoGame(gameDTO));
        return new ResponseEntity(gameMapper.gameToGameDTO(game), HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a Game")
    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity deleteGame(@PathVariable Integer id){
        gameService.deleteGame(id);
        return new ResponseEntity("Game deleted successfully", HttpStatus.OK);

    }


}
