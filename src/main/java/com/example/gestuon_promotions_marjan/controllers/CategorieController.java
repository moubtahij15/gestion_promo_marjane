package com.example.gestuon_promotions_marjan.controllers;

import com.example.gestuon_promotions_marjan.DAO.CategorieDAO;
import com.example.gestuon_promotions_marjan.Entity.Categorie;
import com.example.gestuon_promotions_marjan.Entity.Promotion;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.List;
import java.util.stream.Collectors;

public class CategorieController {
    CategorieDAO categorieDAO;
    Categorie categorie;

    public List<Categorie> promotionByStore(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);

//            System.out.println("eee");
//        List<Categorie> categorieList = categorieDAO.findAll();
//        categorieList = categorieList.stream()
////                .filter(promotion -> promotion.getIdStore() == session.getAttribute("id_store"))
//                .collect(Collectors.toList());
//        System.out.println(session.getAttribute("id_store"));
//        if (promotionList.size() != 0) {
//            promotionList.forEach(promotion -> System.out.println(promotion));
//            return promotionList;
//
//        }
        return null;
    }
}
