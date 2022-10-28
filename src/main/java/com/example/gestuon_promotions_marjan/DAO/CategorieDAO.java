package com.example.gestuon_promotions_marjan.DAO;

import com.example.gestuon_promotions_marjan.Entity.Categorie;
import com.example.gestuon_promotions_marjan.Entity.SousCategorie;
import com.example.gestuon_promotions_marjan.helpers.Enum;
import com.example.gestuon_promotions_marjan.helpers.JPA;

import java.util.List;

public class CategorieDAO implements IDAO<Categorie> {


    @Override
    public Categorie save(Categorie categorie) {
        return null;
    }

    @Override
    public List<Categorie> findAll() {
        return null;
    }

    @Override
    public List<Categorie> findByDesignation(String mc) {
        return null;
    }

    @Override
    public Categorie findByid(long id) {
        return JPA.entityManager().find(Categorie.class, id);
    }

    public Categorie findBySouCategorie(long id) {
        return JPA.entityManager().find(SousCategorie.class, id).getCategorieByIdCategorie();
    }

    @Override
    public Categorie update(Categorie T) {
        return null;
    }

    public boolean asignCategorieRespnsable(int idCategorie, int idRespo) {
        JPA.serv(entityManager -> entityManager.createNativeQuery("UPDATE Categorie SET id_respo =:id_respo WHERE id =:id ")
                .setParameter("id_respo", idRespo)
                .setParameter("id", idCategorie).executeUpdate());

        return true;
    }

    @Override
    public Categorie delete(long id) {
        return null;
    }
}
