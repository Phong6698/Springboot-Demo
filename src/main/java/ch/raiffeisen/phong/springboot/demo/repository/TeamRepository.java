package ch.raiffeisen.phong.springboot.demo.repository;




import ch.raiffeisen.phong.springboot.demo.domain.Team;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class TeamRepository{

    @PersistenceContext
    protected EntityManager em;

    public TeamRepository() {
        em = RepositoryEntityManager.getInstance();
    }

    public List<Team> getAllTeams(){
        return em.createNamedQuery("Team.getAllTeams").getResultList();
    }

    public void addTeam(Team team){
        em.getTransaction().begin();
        em.persist(team);
        em.getTransaction().commit();
    }

}
