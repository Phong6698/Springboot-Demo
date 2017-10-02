package ch.raiffeisen.phong.springboot.demo.mapper;

import ch.raiffeisen.phong.springboot.demo.domain.TeamGame;
import ch.raiffeisen.phong.springboot.demo.dto.TeamGameDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface TeamGameMapper {


    @Mappings({
            @Mapping(target="teamName", source="teamGame.team.name")
    })
    TeamGameDTO teamGameToTeamGameDTO(TeamGame teamGame);

    @Mappings({
            @Mapping(target="team.name", source="teamGameDTO.teamName")
    })
    TeamGame teamGameDTOtoTeamGame(TeamGameDTO teamGameDTO);

}
