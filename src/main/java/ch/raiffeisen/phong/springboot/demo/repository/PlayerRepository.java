package ch.raiffeisen.phong.springboot.demo.repository;

import ch.raiffeisen.phong.springboot.demo.domain.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;




@RepositoryRestResource
public interface PlayerRepository extends CrudRepository<Player, Integer>{
    Player findByEmail(String email);
    Iterable<Player> findAllByFirstNameContainsOrLastNameContainsOrEmailContains(String firstname, String lastname, String email);

}
