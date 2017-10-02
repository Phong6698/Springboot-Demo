package ch.raiffeisen.phong.springboot.demo.controller;

import ch.raiffeisen.phong.springboot.demo.domain.Game;
import ch.raiffeisen.phong.springboot.demo.dto.GamePlayedDTO;
import ch.raiffeisen.phong.springboot.demo.dto.GameUnplayedDTO;
import ch.raiffeisen.phong.springboot.demo.mapper.GameMapper;
import ch.raiffeisen.phong.springboot.demo.service.GameService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

}
