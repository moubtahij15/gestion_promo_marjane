package com.example.gestuon_promotions_marjan.helpers;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.function.Consumer;

public class JPA {
    private static EntityManagerFactory emf;
    private static EntityManager em;

    static {
        emf = Persistence.createEntityManagerFactory("marjane");
        em = emf.createEntityManager();
    }

    public static void serv(Consumer<EntityManager> action){
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            action.accept(em);
            tr.commit();
        }catch (RuntimeException re){
            tr.rollback();
            throw re;
        }
    }

    public static EntityManagerFactory entityManagerFactory() {
        return emf;
    }

    public static EntityManager entityManager() {
        return em;
    }

}