package com.example.gestuon_promotions_marjan.DAO;

import com.example.gestuon_promotions_marjan.Entity.Promotion;
import com.example.gestuon_promotions_marjan.Entity.ResponsableRayon;
import com.example.gestuon_promotions_marjan.Entity.User;
import com.example.gestuon_promotions_marjan.helpers.Hash;
import com.example.gestuon_promotions_marjan.helpers.JPA;
import jakarta.persistence.Query;

import java.util.List;

public class ResponsableRayonDAO implements IDAO<ResponsableRayon> {
    @Override
    public ResponsableRayon save(ResponsableRayon responsableRayon) {
        new JPA().serv(em -> em.persist(responsableRayon));
        return responsableRayon;
    }

    @Override
    public List<ResponsableRayon> findAll() {
        return null;
    }

    @Override
    public List<ResponsableRayon> findByDesignation(String mc) {
        return null;
    }

    @Override
    public ResponsableRayon findByid(int id) {
        return null;
    }

    @Override
    public ResponsableRayon update(ResponsableRayon T) {
        return null;
    }

    @Override
    public ResponsableRayon delete(long id) {
        ResponsableRayon responsableRayon= new JPA().getEm().find(ResponsableRayon.class,id);
        new JPA().serv(em -> em.remove(em.contains(responsableRayon) ? responsableRayon : em.merge(responsableRayon)));
        return responsableRayon;
    }
    public ResponsableRayon login(ResponsableRayon responsableRayon) throws Exception {
        ResponsableRayon responsable_rayon1 = new ResponsableRayon();
        try {

            Query query =  new JPA().getEm().createQuery("select responsable_rayon from ResponsableRayon responsable_rayon where  responsable_rayon.email=:email");
            query.setParameter("email", responsableRayon.getEmail());
            responsable_rayon1 = (ResponsableRayon) query.getSingleResult();
            System.out.println("LOGIN respo 1");
            System.out.println(responsable_rayon1.getPass());
            System.out.println( Hash.MD5(responsableRayon.getPass()));

        } catch (Exception e) {

            return null;
        }

//
        if ( Hash.MD5(responsableRayon.getPass()).equals(responsable_rayon1.getPass())) {
            System.out.println("LOGIN 2");
            return responsable_rayon1;
        }
        return null;
    }
}
