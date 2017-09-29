package ch.raiffeisen.phong.springboot.demo.mapper;

import ch.raiffeisen.phong.springboot.demo.domain.Player;
import ch.raiffeisen.phong.springboot.demo.domain.Team;
import ch.raiffeisen.phong.springboot.demo.dto.PlayerDTO;
import ch.raiffeisen.phong.springboot.demo.dto.TeamDTO;
import ch.raiffeisen.phong.springboot.demo.dto.TeamNewUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface TeamMapper {

    //TeamDTO
    TeamDTO teamToTeamDTO(Team team);
    Team teamDTOtoTeam(TeamDTO teamDTO);
    Iterable<TeamDTO> teamIterableToTeamDTOIterable(Iterable<Team> team);

    //TeamNewUpdateDTO
    TeamNewUpdateDTO teamToTeamNewUpdateDTO(Team team);
    Team teamNewUpdateDTOtoTeam(TeamNewUpdateDTO teamNewUpdateDTO);

    @Mappings({
            @Mapping(target="teamName", source="player.team.name")
    })
    PlayerDTO playerToPlayerDTO(Player player);
    @Mappings({
            @Mapping(target="team.name", source="playerDTO.teamName")
    })
    Player playerDTOtoPlayer(PlayerDTO playerDTO);




}
