package ch.raiffeisen.phong.springboot.demo.mapper;

import ch.raiffeisen.phong.springboot.demo.domain.Game;
import ch.raiffeisen.phong.springboot.demo.domain.Team;
import ch.raiffeisen.phong.springboot.demo.domain.TeamGame;
import ch.raiffeisen.phong.springboot.demo.dto.*;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface GameMapper {

    GamePlayedDTO gameToGamePlayedDTO(Game game);
    Game gamePlayedDTOtoGame(GamePlayedDTO gamePlayedDTO);
    @IterableMapping(elementTargetType = GamePlayedDTO.class)
    Iterable<GamePlayedDTO> gameIterableToGamePlayedDTOIterable(Iterable<Game> game);

    GameUnplayedDTO gameToGameUnplayedDTO(Game game);
    Game gameUnplayedDTOtoGame(GameUnplayedDTO gameUnplayedDTO);
    @IterableMapping(elementTargetType = GameUnplayedDTO.class)
    Iterable<GameUnplayedDTO> gameIterableToGameUnplayedDTOIterable(Iterable<Game> game);

    GameNewDTO gameToGameNewDTO(Game game);
    Game gameNewDTOtoGame(GameNewDTO gameNewDTO);



    GameDTO gamtToGameDTO(Game game);
    Game gameDTOtoGame(GameDTO gameDTO);
    @IterableMapping(elementTargetType = GameDTO.class)
    Iterable<GameDTO> gameIterableToGameDTOIterable(Iterable<Game> game);

    @Mappings({
            @Mapping(target="teamId", source="teamGame.team.id")/*,
            @Mapping(target="gameId", source="teamGame.game.id")*/
    })
    TeamGameNewDTO teamGameToTeamGameNewDTO(TeamGame teamGame);

    @Mappings({
            @Mapping(target="team.id", source="teamId")/*,
            @Mapping(target="game.id", source="gameId")*/
    })
    TeamGame teamGameNewDTOtoTeamGame(TeamGameNewDTO teamGameNewDTO);


    @Mappings({
            @Mapping(target="teamName", source="teamGame.team.name"),
            @Mapping(target="teamId", source="teamGame.team.id")
    })
    TeamGameDTO teamGameToTeamGameDTO(TeamGame teamGame);

    @Mappings({
            @Mapping(target="team.name", source="teamGameDTO.teamName"),
            @Mapping(target="team.id", source="teamGameDTO.teamId")
    })
    TeamGame teamGameDTOtoTeamGame(TeamGameDTO teamGameDTO);

}
