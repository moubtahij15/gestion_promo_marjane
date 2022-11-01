package com.example.gestuon_promotions_marjan.controllers;

import com.example.gestuon_promotions_marjan.DAO.CategorieDAO;
import com.example.gestuon_promotions_marjan.DAO.StoreDAO;
import com.example.gestuon_promotions_marjan.Entity.Categorie;
import com.example.gestuon_promotions_marjan.Entity.Promotion;
import com.example.gestuon_promotions_marjan.Entity.ResponsableRayon;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CategorieController {
    CategorieDAO categorieDAO;
    Categorie categorie;

//    public List<ResponsableRayon> promotionByStore(HttpServletRequest request, HttpServletResponse response) {
//        HttpSession session = request.getSession(false);
//
//            System.out.println("eee");
//        List<ResponsableRayon> categorieList = new ArrayList<>();
//        categorieList =  new StoreDAO().findByid((Long) session.getAttribute("id_store")).getResponsableRayonsById().stream().collect(Collectors.toList());
//
////                stream().
////                .filter(categorie ->categorie.getCategorieStoresById(). == session.getAttribute("id_store"))
////                .collect(Collectors.toList());
//        System.out.println(session.getAttribute("id_store"));
//        if (categorieList.size() != 0) {
//            categorieList.forEach(c -> System.out.println(promotion));
//            return categorieList;
//
//        }
//        return null;
//    }
}
