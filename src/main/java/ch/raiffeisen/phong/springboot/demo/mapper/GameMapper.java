package ch.raiffeisen.phong.springboot.demo.mapper;

import ch.raiffeisen.phong.springboot.demo.domain.Game;
import ch.raiffeisen.phong.springboot.demo.domain.TeamGame;
import ch.raiffeisen.phong.springboot.demo.dto.GamePlayedDTO;
import ch.raiffeisen.phong.springboot.demo.dto.GameUnplayedDTO;
import ch.raiffeisen.phong.springboot.demo.dto.TeamGameDTO;
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



    @Mappings({
            @Mapping(target="teamName", source="teamGame.team.name")
    })
    TeamGameDTO teamGameToTeamGameDTO(TeamGame teamGame);

    @Mappings({
            @Mapping(target="team.name", source="teamGameDTO.teamName")
    })
    TeamGame teamGameDTOtoTeamGame(TeamGameDTO teamGameDTO);

}
