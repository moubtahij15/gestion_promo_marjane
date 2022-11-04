package com.example.gestuon_promotions_marjan.controllers;

import com.example.gestuon_promotions_marjan.DAO.CategorieDAO;
import com.example.gestuon_promotions_marjan.DAO.StoreDAO;
import com.example.gestuon_promotions_marjan.Entity.Categorie;
import com.example.gestuon_promotions_marjan.Entity.ResponsableRayon;
import com.example.gestuon_promotions_marjan.Entity.Store;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

public class CategorieController {
    CategorieDAO categorieDAO;
    Categorie categorie;


    public List<Categorie> AllcategorieByStore(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        int idStore = (int) session.getAttribute("id_store");
        List<Categorie> categorieLists = new ArrayList<>();
        categorieLists = new StoreDAO().findByid(idStore).getCategoriesById().stream().toList();
        if (categorieLists.size() != 0) {
            categorieLists.forEach(categorieStore -> System.out.println("all Ca " + categorieStore.getNom()));
//            categorieList.get(1).getSousCategoriesById().forEach(categorieLisst -> System.out.println(categorieLisst.getNom()));
            return categorieLists;
//
        }

        return null;
    }

    public List<Categorie> FreeCategorieByStore(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        int idStore = (int) session.getAttribute("id_store");
        List<Categorie> categorieLists = new ArrayList<>();
        categorieLists = new StoreDAO().findByid(idStore).getCategoriesById().stream().filter(categorie1 -> categorie1.getResponsableRayonsById() == null).toList();
        if (categorieLists.size() != 0) {
            categorieLists.forEach(categorieStore -> System.out.println(categorieStore.getNom()));
//            categorieList.get(1).getSousCategoriesById().forEach(categorieLisst -> System.out.println(categorieLisst.getNom()));
            return categorieLists;
//
        }
        return null;
    }
}



