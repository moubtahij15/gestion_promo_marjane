package com.example.gestuon_promotions_marjan.DAO;

import com.example.gestuon_promotions_marjan.Entity.Categorie;
import com.example.gestuon_promotions_marjan.Entity.SousCategorie;
import com.example.gestuon_promotions_marjan.helpers.JPA;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class CategorieDAO implements IDAO<Categorie> {


    @Override
    public Categorie save(Categorie categorie) {
        return null;
    }

    @Override
    public List<Categorie> findAll() {
//        EntityManager em = Persistence.createEntityManagerFactory("marjane").createEntityManager();

        Query query = new JPA().getEm().createQuery("select categorie from Categorie categorie ");
        return query.getResultList();
    }

    @Override
    public List<Categorie> findByDesignation(String mc) {
        return null;
    }

    @Override
    public Categorie findByid(int id) {
//        EntityManager em = Persistence.createEntityManagerFactory("marjane").createEntityManager();

        return new JPA().getEm().find(Categorie.class, id);
    }

    public Categorie findBySouCategorie(long id) {
        return new JPA().getEm().find(SousCategorie.class, id).getCategorieByIdCategorie();
    }

    @Override
    public Categorie update(Categorie T) {
        return null;
    }

    public boolean asignCategorieRespnsable(int idCategorie, int idRespo) {
         new JPA().serv(entityManager -> entityManager.createNativeQuery("UPDATE Categorie SET id_respo =:id_respo WHERE id =:id ")
                .setParameter("id_respo", idRespo)
                .setParameter("id", idCategorie).executeUpdate());

        return true;
    }

    @Override
    public Categorie delete(long id) {
        return null;
    }
}
