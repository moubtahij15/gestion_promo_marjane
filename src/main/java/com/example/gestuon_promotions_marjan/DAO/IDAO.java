package com.example.gestuon_promotions_marjan.DAO;

import java.util.List;

public interface IDAO<T> {
    public void save(T t);

    public List<T> findAll();

    public List<T> findByDesignation(String mc);

    public T findByid(long id);

    public void update(T T);

    public void delete(long id);

}
