package com.example.gestuon_promotions_marjan.DAO;

import com.example.gestuon_promotions_marjan.Entity.Promotion;
import com.example.gestuon_promotions_marjan.helpers.Enum;
import com.example.gestuon_promotions_marjan.helpers.JPA;
import jakarta.persistence.Query;

import java.util.List;

public class PromotionDAO implements IDAO<Promotion> {


    @Override
    public void save(Promotion promotion) {
        JPA.serv(em -> em.persist(promotion));

    }

    @Override
    public List<Promotion> findAll() {
        Query query = JPA.entityManager().createQuery("select promotion from Promotion promotion ");
        return query.getResultList();
    }

    public Boolean acceptPromo(long id) {
        Query query = JPA.entityManager().createQuery("UPDATE Promotion SET statut =:statut WHERE id =:id ");
        query.setParameter("statut", Enum.Statut.ACCEPTED.toString());
        query.setParameter("id", id);
        return query.executeUpdate() == 1;
    }


    @Override
    public List<Promotion> findByDesignation(String mc) {
        return null;
    }

    @Override
    public Promotion findByid(long id) {
        return null;
    }

    @Override
    public void update(Promotion T) {

    }


    @Override
    public void delete(long id) {

    }

//    public void displayUser(ArrayList<Promotion> userArrayList) {
//        for (Promotion currentUser : userArrayList) {
//            System.out.println("User {" + currentUser.getId()
//                    + " , name='" + currentUser.getName() + '\'' +
//                    ", email='" + currentUser.getEmail() + '\'' +
//                    ", le nom du store=" + currentUser.getStoreByIdStore().getNom() + '\'' +
//                    ", la ville=" + currentUser.getStoreByIdStore().getVilleByIdVille().getNom() + '\'' +
//                    '}');
//        }
//
//    }
}