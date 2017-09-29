package ch.raiffeisen.phong.springboot.demo.mapper;

import ch.raiffeisen.phong.springboot.demo.domain.Player;
import ch.raiffeisen.phong.springboot.demo.dto.PlayerNewDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

    PlayerNewDTO playerToPlayerNewDTO(Player player);
    Player playerNewDTOtoplayer(PlayerNewDTO playerNewDTO);
}
