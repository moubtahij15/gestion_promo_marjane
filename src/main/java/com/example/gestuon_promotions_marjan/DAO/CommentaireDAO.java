package com.example.gestuon_promotions_marjan.DAO;

import com.example.gestuon_promotions_marjan.Entity.Commentaires;
import com.example.gestuon_promotions_marjan.helpers.JPA;

import java.util.List;

public class CommentaireDAO implements IDAO<Commentaires>{
    @Override
    public void save(Commentaires commentaires) {
        JPA.serv(entityManager -> entityManager.persist(commentaires));
    }

    @Override
    public List<Commentaires> findAll() {
        return null;
    }

    @Override
    public List<Commentaires> findByDesignation(String mc) {
        return null;
    }

    @Override
    public Commentaires findByid(long id) {
        return null;
    }

    @Override
    public void update(Commentaires T) {

    }

    @Override
    public void delete(long id) {

    }
}
