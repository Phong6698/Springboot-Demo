package ch.raiffeisen.phong.springboot.demo.mapper;

import ch.raiffeisen.phong.springboot.demo.domain.Player;
import ch.raiffeisen.phong.springboot.demo.dto.PlayerDTO;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

    PlayerDTO playerToPlayerDTO(Player player);
    Player playerDTOtoPlayer(PlayerDTO playerDTO);

    @IterableMapping(elementTargetType = PlayerDTO.class)
    Iterable<PlayerDTO> playerIterableToPlayerDTOIterable(Iterable<Player> players);
}
