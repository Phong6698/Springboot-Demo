package ch.raiffeisen.phong.springboot.demo.repository;




import ch.raiffeisen.phong.springboot.demo.domain.Game;
import ch.raiffeisen.phong.springboot.demo.domain.Player;
import ch.raiffeisen.phong.springboot.demo.domain.Team;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface TeamRepository extends CrudRepository<Team, Integer> {
    Team findByName(String name);

    /* Man kann auch @Query("") Notation benutzen
     * https://docs.spring.io/spring-data/jpa/docs/1.6.0.RELEASE/reference/html/jpa.repositories.html
     *
     * Join?
     * https://stackoverflow.com/questions/19977130/joining-two-table-entities-in-spring-data-jpa
     */

/*    Team findByPlayers(Integer id);*/
}
