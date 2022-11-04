package com.example.gestuon_promotions_marjan.DAO;

import com.example.gestuon_promotions_marjan.Entity.Store;
import com.example.gestuon_promotions_marjan.helpers.JPA;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.util.List;

public class StoreDAO implements IDAO<Store> {
    @Override
    public Store save(Store store) {
        return null;
    }

    @Override
    public List<Store> findAll() {
        return null;
    }

    @Override
    public List<Store> findByDesignation(String mc) {
        return null;
    }

    public StoreDAO() {
    }

    @Override
    public Store findByid(int id) {

//        EntityManager em = Persistence.createEntityManagerFactory("marjane").createEntityManager();

        return new JPA().getEm().find(Store.class, id);
    }

    @Override
    public Store update(Store T) {
        return null;
    }

    @Override
    public Store delete(long id) {
        return null;
    }
}
