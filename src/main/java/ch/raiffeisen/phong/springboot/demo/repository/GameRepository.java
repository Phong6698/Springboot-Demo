package ch.raiffeisen.phong.springboot.demo.repository;



import ch.raiffeisen.phong.springboot.demo.domain.Game;
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
public interface GameRepository extends CrudRepository<Game, Integer>{
    Iterable<Game> findAllByTimePlayedIsNotNullOrderByTimePlayedDesc();
    Iterable<Game> findAllByTimePlayedIsNullOrderByTimePlanedAsc();
}
