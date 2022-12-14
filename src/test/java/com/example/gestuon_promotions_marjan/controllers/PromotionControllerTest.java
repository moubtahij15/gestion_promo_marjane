//package com.example.gestuon_promotions_marjan.controllers;
//
//import com.example.gestuon_promotions_marjan.Entity.Commentaires;
//import com.example.gestuon_promotions_marjan.Entity.Promotion;
//import com.example.gestuon_promotions_marjan.helpers.Enum;
//import org.junit.jupiter.api.Test;
//
//import java.sql.Date;
//import java.time.LocalDate;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class PromotionControllerTest {
//    PromotionController promotionController = new PromotionController();
//
//    @Test
//    void ajouterPromotionCategorie() {
//        Promotion promotion = new Promotion();
//        promotion.setDateDebut(Date.valueOf(LocalDate.of(2022, 10, 28)));
//        promotion.setDateFin(Date.valueOf(LocalDate.of(2022, 10, 30)));
//        promotion.setPoucentage(20.0);
//        promotion.setIdCategorie(4);
//        promotion.setIdStore(1);
//        promotion.setStatut(Enum.Statut.PENDING.toString());
//        promotion.setType(Enum.Type.CATEGORIE.toString());
//        promotion.setIdSousCategorie(null);
//        assertTrue(promotionController.ajouterPromotionCategorie(promotion));
//    }
//
//    @Test
//    void testAjouterPromotionSousCategorie() {
//        PromotionController promotionController = new PromotionController();
//        Promotion promotion = new Promotion();
//        promotion.setDateDebut(Date.valueOf(LocalDate.of(2022, 2, 2)));
//        promotion.setDateFin(Date.valueOf(LocalDate.of(2022, 2, 12)));
//        promotion.setPoucentage(30.0);
//        promotion.setIdCategorie(null);
//        promotion.setIdStore(1);
//        promotion.setStatut(Enum.Statut.PENDING.toString());
//        promotion.setType(Enum.Type.CATEGORIE.toString());
//        promotion.setIdSousCategorie(1);
//        assertTrue(promotionController.ajouterPromotionSousCategorie(promotion));
//    }
//
//
//    @Test
//    void pendingPromotionByResponsable() {
//
////        promotionController.pendingPromotionByResponsable(36);
//        assertNotNull(promotionController.pendingPromotionByResponsable(39));
//    }
//
//    @Test
//    void acceptPromotion() {
//        assertTrue(promotionController.acceptPromotion(14, new Commentaires("Bien valid??", 9)));
//    }
//
//    @Test
//    void refusPromotion() {
//        assertTrue(promotionController.refusPromotion(8));
//
//    }
//
//    @Test
//    void acceptedPromotionByResponsable() {
//        assertNotNull(promotionController.acceptedPromotionByResponsable(39));
//
//    }
//
////    @Test
////    void promotionByStore() {
////        assertNotNull(promotionController.promotionByStore(1, Enum.Statut.ACCEPTED.toString()));
////
////    }
//}