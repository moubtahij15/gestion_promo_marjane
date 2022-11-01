package com.example.gestuon_promotions_marjan.DAO;

import java.util.List;

public interface IDAO<T> {
    public T save(T t);

    public List<T> findAll();

    public List<T> findByDesignation(String mc);

    public T findByid(int id);

    public T update(T T);

    public T delete(long id);

}
