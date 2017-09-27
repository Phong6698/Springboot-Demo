package ch.raiffeisen.phong.springboot.demo.repository;



import ch.raiffeisen.phong.springboot.demo.domain.Game;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class GameRepository {
    @PersistenceContext
    protected EntityManager em;

    public GameRepository() {
        em = RepositoryEntityManager.getInstance();
    }

    public List<Game> getAllTeamGames(){
        return em.createNamedQuery("Game.getAllGames").getResultList();
    }

    public void addTeamGame(Game game){
        em.getTransaction().begin();
        em.persist(game);
        em.getTransaction().commit();
    }

    public List<Game> getAllUnplayedGames(){
        return em.createNamedQuery("Game.getAllUnplayedGames").getResultList();
    }

    public List<Game> getAllPlayedGames(){
        return em.createNamedQuery("Game.getAllPlayedGames").getResultList();
    }


}
