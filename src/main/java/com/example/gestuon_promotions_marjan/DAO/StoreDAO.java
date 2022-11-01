package com.example.gestuon_promotions_marjan.DAO;

import com.example.gestuon_promotions_marjan.Entity.Store;
import com.example.gestuon_promotions_marjan.Entity.User;
import com.example.gestuon_promotions_marjan.helpers.JPA;

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
        return JPA.entityManager().find(Store.class, id);
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
