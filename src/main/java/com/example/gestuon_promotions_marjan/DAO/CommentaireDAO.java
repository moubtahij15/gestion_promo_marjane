package com.example.gestuon_promotions_marjan.DAO;

import com.example.gestuon_promotions_marjan.Entity.Commentaires;
import com.example.gestuon_promotions_marjan.helpers.JPA;

import java.util.List;

public class CommentaireDAO implements IDAO<Commentaires> {
    @Override
    public Commentaires save(Commentaires commentaires) {
        new JPA().serv(entityManager -> entityManager.persist(commentaires));
        return commentaires;
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
    public Commentaires findByid(int id) {
        return null;
    }

    @Override
    public Commentaires update(Commentaires T) {
        return null;
    }

    @Override
    public Commentaires delete(long id) {
        return null;
    }
}
