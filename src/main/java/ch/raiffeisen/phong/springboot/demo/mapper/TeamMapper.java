package ch.raiffeisen.phong.springboot.demo.mapper;

import ch.raiffeisen.phong.springboot.demo.domain.Team;
import ch.raiffeisen.phong.springboot.demo.dto.TeamDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeamMapper {

    TeamDTO teamToTeamDTO(Team team);
    Team teamDTOtoTeam(TeamDTO teamDTO);
    Iterable<TeamDTO> teamIterableToTeamDTOIterable(Iterable<Team> team);





}
