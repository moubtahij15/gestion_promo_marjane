package com.example.gestuon_promotions_marjan.DAO;

import com.example.gestuon_promotions_marjan.Entity.Promotion;
import com.example.gestuon_promotions_marjan.helpers.Enum;
import com.example.gestuon_promotions_marjan.helpers.JPA;
import jakarta.persistence.Query;

import java.util.List;

public class PromotionDAO implements IDAO<Promotion> {


    @Override
    public Promotion save(Promotion promotion) {
        int fedilité = (int) (promotion.getPoucentage() * 10);
        JPA.serv(em -> em.persist(promotion));
        return promotion;

    }

    @Override
    public List<Promotion> findAll() {
        Query query = JPA.entityManager().createQuery("select promotion from Promotion promotion ");
        return query.getResultList();
    }

    public Boolean acceptPromo(long id) {
        JPA.serv(entityManager -> entityManager.createNativeQuery("UPDATE Promotion SET statut =:statut WHERE id =:id ")
                .setParameter("statut", Enum.Statut.ACCEPTED.toString())
                .setParameter("id", id).executeUpdate());

        return true;
    }

    public Boolean refusPromo(long id) {
        JPA.serv(entityManager -> entityManager.createNativeQuery("UPDATE Promotion SET statut =:statut WHERE id =:id ")
                .setParameter("statut", Enum.Statut.REFUSED.toString())
                .setParameter("id", id).executeUpdate());

        return true;
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
    public Promotion update(Promotion T) {
        return null;
    }

    @Override
    public Promotion delete(long id) {
        return null;
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
