package ch.raiffeisen.phong.springboot.demo.repository;


import ch.raiffeisen.phong.springboot.demo.domain.TeamGame;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class TeamGameRepository {
    @PersistenceContext
    protected EntityManager em;

    public TeamGameRepository() {
        em = RepositoryEntityManager.getInstance();
    }

    public List<TeamGame> getAllTeamGames(){
        return em.createNamedQuery("TeamGame.getAllTeamGames").getResultList();
    }

    public void addTeamGame(TeamGame teamGame){
        em.getTransaction().begin();
        em.persist(teamGame);
        em.getTransaction().commit();
    }

}
