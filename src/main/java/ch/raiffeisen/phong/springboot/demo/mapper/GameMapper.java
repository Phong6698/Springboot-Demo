package ch.raiffeisen.phong.springboot.demo.mapper;

import ch.raiffeisen.phong.springboot.demo.domain.Game;
import ch.raiffeisen.phong.springboot.demo.domain.Team;
import ch.raiffeisen.phong.springboot.demo.domain.TeamGame;
import ch.raiffeisen.phong.springboot.demo.dto.*;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GameMapper {

    GameDTO gameToGameDTO(Game game);
    Game gameDTOtoGame(GameDTO gameDTO);
    @IterableMapping(elementTargetType = GameDTO.class)
    Iterable<GameDTO> gameIterableToGameDTOIterable(Iterable<Game> game);

    TeamDTO teamToTeamDTO(Team team);
    Team teamDTOtoTeam(TeamDTO teamDTO);

    TeamGameDTO teamGameToTeamGameDTO(TeamGame teamGame);
    TeamGame teamGameDTOtoTeamGame(TeamGameDTO teamGameDTO);

}
