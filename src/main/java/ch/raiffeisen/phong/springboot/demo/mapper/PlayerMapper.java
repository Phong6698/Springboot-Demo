package ch.raiffeisen.phong.springboot.demo.mapper;

import ch.raiffeisen.phong.springboot.demo.domain.Player;
import ch.raiffeisen.phong.springboot.demo.dto.PlayerDTO;
import ch.raiffeisen.phong.springboot.demo.dto.PlayerNewUpdateDTO;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PlayerMapper {


    //PlayerNewUpdateDTO
    PlayerNewUpdateDTO playerToPlayerNewUpdateDTO(Player player);
    Player playerNewUpdateDTOtoplayer(PlayerNewUpdateDTO playerNewUpdateDTO);

    //PlayerDTO
    @Mappings({
            @Mapping(target="teamName", source="player.team.name")
    })
    PlayerDTO playerToPlayerDTO(Player player);

    @Mappings({
            @Mapping(target="team.name", source="playerDTO.teamName")
    })
    Player playerDTOtoPlayer(PlayerDTO playerDTO);

    @IterableMapping(elementTargetType = PlayerDTO.class)
    Iterable<PlayerDTO> playerIterableToPlayerDTOIterable(Iterable<Player> players);
}
