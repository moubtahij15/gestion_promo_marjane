package com.example.gestuon_promotions_marjan.controllers;

import com.example.gestuon_promotions_marjan.DAO.CategorieDAO;
import com.example.gestuon_promotions_marjan.DAO.CommentaireDAO;
import com.example.gestuon_promotions_marjan.DAO.PromotionDAO;
import com.example.gestuon_promotions_marjan.Entity.Categorie;
import com.example.gestuon_promotions_marjan.Entity.Commentaires;
import com.example.gestuon_promotions_marjan.Entity.Promotion;
import com.example.gestuon_promotions_marjan.helpers.Enum;
import com.example.gestuon_promotions_marjan.servlets.AdminStoreServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PromotionController {
    PromotionDAO promotionDAO;
    Promotion promotion;


    public PromotionController() {
        this.promotionDAO = new PromotionDAO();
        this.promotion = new Promotion();
    }

    public boolean ajouterPromotion(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        System.out.println(request.getParameter("date_depart"));
//        get values
        AdminStoreServlet.error = new ArrayList<>();
        HttpSession session = request.getSession(false);
        promotion.setIdCategorie(Integer.valueOf(request.getParameter("categorie")));
        promotion.setType(request.getParameter("type"));
        promotion.setIdStore((Integer) session.getAttribute("id_store"));
        promotion.setPoucentage(Double.valueOf(request.getParameter("pourcentage")));
        promotion.setDateDebut(Date.valueOf(request.getParameter("date_depart")));
        promotion.setDateFin(Date.valueOf(request.getParameter("date_fin")));
        promotion.setStatut(Enum.Statut.PENDING.toString());
        if (request.getParameter("type").equals(Enum.Type.SUBCATEGORIE.toString())) {
            promotion.setIdSousCategorie(Integer.valueOf(request.getParameter("sous_categorie")));
        } else {
            promotion.setIdSousCategorie(null);
        }
        System.out.println(promotion);
//
////        traitement
        if (promotion.getPoucentage() > 50) {
            AdminStoreServlet.error.add("le pourcentage de promotion ne dois pas passe 50% ");
            return false;
        }
        if ((promotion.getPoucentage() > 20) && (new CategorieDAO().findByid(promotion.getIdCategorie()).getNom().equals("Multimedia"))) {
            AdminStoreServlet.error.add("le pourcentage de promotion pour la categorie Multimedia ne dois pas passe 50% ");

            return false;
        }

        promotion.setFedelite((Double) (promotion.getPoucentage() * 10));
        return promotionDAO.save(promotion) != null;

    }

    boolean ajouterPromotionSousCategorie(Promotion promotion) {
        Categorie categorie = new CategorieDAO().findBySouCategorie(promotion.getIdSousCategorie());
        promotion.setIdCategorie(categorie.getId());
//        System.out.println(categorie.getNom());
        promotion.setFedelite((Double) (promotion.getPoucentage() * 10));

        return promotionDAO.save(promotion) != null;
    }

    public List<Promotion> pendingPromotionByResponsable(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession(false);
        int id = (int) session.getAttribute("id");
        int idStore = (int) session.getAttribute("id_store_respo");
        LocalTime now = LocalTime.now();
        LocalTime startTime = LocalTime.parse("08:00");
        LocalTime endTime = LocalTime.parse("23:00");
//        if ((now.isAfter(startTime) && now.isBefore(endTime))) {
//            System.out.println("eee");
            List<Promotion> promotionList = promotionDAO.findAll();
            promotionList = promotionList.stream()
                    .filter(promotion -> promotion.getStatut().equals(Enum.Statut.PENDING.toString()))
                    .filter(promotion -> (promotion.getDateDebut().toLocalDate().compareTo(LocalDate.now()) <= 0))
                    .filter((promotion -> LocalDate.now().isBefore(promotion.getDateFin().toLocalDate())))
                    .filter(promotion -> promotion.getCategorieByIdCategorie().getResponsableRayonsById().getId() == id)
                    .filter(promotion -> promotion.getIdStore() == idStore)
                    .collect(Collectors.toList());
            if (promotionList.size() != 0) {
                promotionList.forEach(promotion -> System.out.println(promotion.getId()));

//            }
            return promotionList;

        }

        return null;
    }

    public List<Promotion> acceptedPromotionByResponsable(int id) {

        List<Promotion> promotionList = promotionDAO.findAll();
        promotionList = promotionList.stream()
//                .filter(promotion -> promotion.getCategorieByIdCategorie().getIdRespo() == id)
                .filter(promotion -> promotion.getStatut().equals(Enum.Statut.ACCEPTED.toString()))
                .collect(Collectors.toList());
        if (promotionList.size() != 0) {
            promotionList.forEach(promotion -> System.out.println(promotion));
            return promotionList;

        }

        return null;
    }

    public List<Promotion> promotionByStoreStatut(int id, String statut) {

//            System.out.println("eee");
        List<Promotion> promotionList = promotionDAO.findAll();
        promotionList = promotionList.stream()
                .filter(promotion -> promotion.getIdStore() == id)
                .filter(promotion -> promotion.getStatut().equals(statut))
                .collect(Collectors.toList());
        if (promotionList.size() != 0) {
//            promotionList.forEach(promotion -> System.out.println(promotion));
            return promotionList;

        }
        return null;


    }

    public List<Promotion> promotionByStore(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession(false);

//            System.out.println("eee");
        List<Promotion> promotionList = promotionDAO.findAll();
        promotionList = promotionList.stream()
                .filter(promotion -> promotion.getIdStore() == session.getAttribute("id_store"))
                .collect(Collectors.toList());
//        System.out.println(session.getAttribute("id_store"));
        if (promotionList.size() != 0) {
            promotionList.forEach(promotion -> System.out.println(promotion));
            return promotionList;

        }
        return null;


    }


    public List<Promotion> allPromotion(HttpServletRequest request, HttpServletResponse response){
        List<Promotion> promotionList = promotionDAO.findAll();
        promotionList = promotionList.stream().toList();
        System.out.println("all promo from all promotion");
        if (promotionList.size() != 0) {
            promotionList.forEach(promotion -> System.out.println(promotion.getId()));
            return promotionList;

        }
        return null;
    }

    public boolean supprimerPromotion(HttpServletRequest request, HttpServletResponse response) {
        if ((promotionDAO.delete(Long.parseLong(request.getParameter("idPromo")))) != null) {
            System.out.println("test valide");
            return true;
        }
        System.out.println("test invalide");

        return false;
    }

    public boolean acceptPromotion(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idPromo"));

        Commentaires commentaires = new Commentaires();
        commentaires.setCommentaire(request.getParameter("commentaire"));
        commentaires.setIdPromo(id);
        if (promotionDAO.acceptPromo(id)) {
            new CommentaireDAO().save(commentaires);
            return true;
        }
        return false;

    }

    public boolean refusPromotion(HttpServletRequest request, HttpServletResponse response) {

        if (promotionDAO.refusPromo(Long.parseLong(request.getParameter("idPromo")))) {
            return true;
        }
        return false;

    }

}

