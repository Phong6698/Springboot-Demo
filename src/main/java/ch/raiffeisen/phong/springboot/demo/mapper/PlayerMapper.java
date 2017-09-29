package ch.raiffeisen.phong.springboot.demo.mapper;

import ch.raiffeisen.phong.springboot.demo.domain.Player;
import ch.raiffeisen.phong.springboot.demo.dto.PlayerDTO;
import ch.raiffeisen.phong.springboot.demo.dto.PlayerNewDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

    PlayerNewDTO playerToPlayerNewDTO(Player player);
    Player playerNewDTOtoplayer(PlayerNewDTO playerNewDTO);

    @Mappings({
            @Mapping(target="teamName", source="player.team.name")
    })
    PlayerDTO playerToPlayerDTO(Player player);

    @Mappings({
            @Mapping(target="team.name", source="playerDTO.teamName")
    })
    Player playerDTOtoPlayer(PlayerDTO playerDTO);
}
