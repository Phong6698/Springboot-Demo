package ch.raiffeisen.phong.springboot.demo.repository;

import ch.raiffeisen.phong.springboot.demo.domain.Player;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class PlayerRepository{

    @PersistenceContext
    protected EntityManager em;

    public PlayerRepository() {
        em = RepositoryEntityManager.getInstance();
    }

    public List<Player> getAllPlayers(){
        return em.createNamedQuery("Player.getAllPlayers").getResultList();
    }

    public void addPlayer(Player player){
        em.getTransaction().begin();
        em.persist(player);
        em.getTransaction().commit();
    }

    public Player getPlayerById(int id){
        return em.find(Player.class, id);
    }

    public void updatePlayer(Player player) {
        em.getTransaction().begin();
        em.merge(player);
        em.getTransaction().commit();
    }
}
