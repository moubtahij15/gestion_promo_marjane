package com.example.gestuon_promotions_marjan.DAO;

import com.example.gestuon_promotions_marjan.Entity.Categorie;
import com.example.gestuon_promotions_marjan.Entity.SousCategorie;
import com.example.gestuon_promotions_marjan.helpers.JPA;

import java.util.List;

public class CategorieDAO implements IDAO<Categorie> {


    @Override
    public void save(Categorie categorie) {

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
    public void update(Categorie T) {

    }

    @Override
    public void delete(long id) {

    }
}
