package ch.raiffeisen.phong.springboot.demo.repository;



import ch.raiffeisen.phong.springboot.demo.domain.Game;

import com.ibm.security.certclient.base.PkAttrs;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



@RepositoryRestResource
public interface GameRepository extends CrudRepository<Game, Integer>{
    Iterable<Game> findAllByTimePlayedIsNotNullOrderByTimePlayedDesc();
    Iterable<Game> findAllByTimePlayedIsNullOrderByTimePlanedAsc();
    Iterable<Game> findAllByTimePlayedIsNotNullAndIdInOrderByTimePlayedDesc(Iterable<Integer> ids);
    Iterable<Game> findAllByTimePlayedIsNullAndIdInOrderByTimePlanedAsc(Iterable<Integer> ids);
}
