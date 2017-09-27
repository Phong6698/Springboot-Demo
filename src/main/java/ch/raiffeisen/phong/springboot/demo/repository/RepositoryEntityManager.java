package ch.raiffeisen.phong.springboot.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class RepositoryEntityManager {
    private static EntityManager instance;

    private RepositoryEntityManager() {
    }

    public static synchronized EntityManager getInstance(){
        if(RepositoryEntityManager.instance == null){
            RepositoryEntityManager.instance = Persistence.createEntityManagerFactory("Phong-WM").createEntityManager();
        }
        return RepositoryEntityManager.instance;
    }
}
