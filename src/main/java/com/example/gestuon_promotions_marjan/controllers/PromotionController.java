package com.example.gestuon_promotions_marjan.controllers;

import com.example.gestuon_promotions_marjan.DAO.CategorieDAO;
import com.example.gestuon_promotions_marjan.DAO.CommentaireDAO;
import com.example.gestuon_promotions_marjan.DAO.PromotionDAO;
import com.example.gestuon_promotions_marjan.Entity.Categorie;
import com.example.gestuon_promotions_marjan.Entity.Commentaires;
import com.example.gestuon_promotions_marjan.Entity.Promotion;
import com.example.gestuon_promotions_marjan.helpers.Enum;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PromotionController {
    PromotionDAO promotionDAO;


    public PromotionController() {
        this.promotionDAO = new PromotionDAO();
    }

    boolean ajouterPromotionCategorie(Promotion promotion) {

        if (promotion.getPoucentage() > 50) {
            return false;
        }
        if ((promotion.getPoucentage() > 20) && (new CategorieDAO().findByid(promotion.getIdCategorie()).getNom().equals("Multimedia"))) {
            return false;
        }

        return promotionDAO.save(promotion) != null;

    }

    boolean ajouterPromotionSousCategorie(Promotion promotion) {
        Categorie categorie = new CategorieDAO().findBySouCategorie(promotion.getIdSousCategorie());
        promotion.setIdCategorie(categorie.getId());
//        System.out.println(categorie.getNom());
        return promotionDAO.save(promotion) != null;
    }

    List<Promotion> pendingPromotionByResponsable(int id) {
        LocalTime now = LocalTime.now();
        LocalTime startTime = LocalTime.parse("08:00");
        LocalTime endTime = LocalTime.parse("16:00");
        if ((now.isAfter(startTime) && now.isBefore(endTime))) {
//            System.out.println("eee");
            List<Promotion> promotionList = promotionDAO.findAll();
            promotionList = promotionList.stream()
                    .filter(promotion -> promotion.getCategorieByIdCategorie().getIdRespo() == id)
                    .filter(promotion -> promotion.getStatut().equals(Enum.Statut.PENDING.toString()))
                    .filter(promotion -> (promotion.getDateDebut().toLocalDate().compareTo(LocalDate.now()) <= 0))
                    .filter((promotion -> LocalDate.now().isBefore(promotion.getDateFin().toLocalDate())))
                    .collect(Collectors.toList());
            if (promotionList.size() != 0) {
                promotionList.forEach(promotion -> System.out.println(promotion));

            }
            return promotionList;

        }

        return null;
    }

    List<Promotion> acceptedPromotionByResponsable(int id) {

        List<Promotion> promotionList = promotionDAO.findAll();
        promotionList = promotionList.stream().filter(promotion -> promotion.getCategorieByIdCategorie().getIdRespo() == id)
                .filter(promotion -> promotion.getStatut().equals(Enum.Statut.ACCEPTED.toString()))
                .collect(Collectors.toList());
        if (promotionList.size() != 0) {
            promotionList.forEach(promotion -> System.out.println(promotion));
            return promotionList;

        }

        return null;
    }

    List<Promotion> promotionByStore(int id, String statut) {

//            System.out.println("eee");
        List<Promotion> promotionList = promotionDAO.findAll();
        promotionList = promotionList.stream()
                .filter(promotion -> promotion.getIdStore() == id)
                .filter(promotion -> promotion.getStatut().equals(statut))
                .collect(Collectors.toList());
        if (promotionList.size() != 0) {
            promotionList.forEach(promotion -> System.out.println(promotion));
            return promotionList;

        }
        return null;


    }

    boolean acceptPromotion(int id, Commentaires commentaires) {
        if (promotionDAO.acceptPromo(id)) {
            new CommentaireDAO().save(commentaires);
            return true;
        }
        return false;

    }

    boolean refusPromotion(int id) {
        if (promotionDAO.refusPromo(id)) {
            return true;
        }
        return false;

    }

}

