package com.example.gestuon_promotions_marjan.controllers;

import com.example.gestuon_promotions_marjan.DAO.StoreDAO;
import com.example.gestuon_promotions_marjan.Entity.ResponsableRayon;
import com.example.gestuon_promotions_marjan.Entity.Store;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResponsableController {
    StoreDAO storeDAO;
    Store store;
    ResponsableRayon responsableRayon;

    public ResponsableController() {
        this.storeDAO = new StoreDAO();
        this.store = new Store();
        this.responsableRayon = new ResponsableRayon();
    }

    public List<ResponsableRayon> ResponsablesRayonByStore(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        List<ResponsableRayon> ResponsableRayonList = new ArrayList<>();

        ResponsableRayonList = (List<ResponsableRayon>) new StoreDAO().findByid((Integer) session.getAttribute("id_store")).getResponsableRayonsById();

//        System.out.println(session.getAttribute("id_store") + "ResponsablesRayonByStore");
//        System.out.println(store1.getNom());
//        System.out.println(store1.getNom());


        if (ResponsableRayonList.size() != 0) {
//            ResponsableRayonList.forEach(ResponsableRayon -> System.out.println("ResponsablesRayonByStore"));
            return ResponsableRayonList;

        }
        return null;
    }
}
