package com.example.gestuon_promotions_marjan.controllers;

import com.example.gestuon_promotions_marjan.DAO.CategorieDAO;
import com.example.gestuon_promotions_marjan.DAO.ResponsableRayonDAO;
import com.example.gestuon_promotions_marjan.DAO.StoreDAO;
import com.example.gestuon_promotions_marjan.Entity.ResponsableRayon;
import com.example.gestuon_promotions_marjan.Entity.Store;
import com.example.gestuon_promotions_marjan.helpers.Enum;
import com.example.gestuon_promotions_marjan.servlets.AdminStoreServlet;
import com.example.gestuon_promotions_marjan.servlets.AuthServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ResponsableController {
    StoreDAO storeDAO;
    Store store;
    ResponsableRayonDAO responsableRayonDAO;
    ResponsableRayon responsableRayon;

    public ResponsableController() {
        this.storeDAO = new StoreDAO();
        this.store = new Store();
        this.responsableRayon = new ResponsableRayon();
        this.responsableRayonDAO = new ResponsableRayonDAO();
    }

    public List<ResponsableRayon> ResponsablesRayonByStore(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        List<ResponsableRayon> ResponsableRayonList = new ArrayList<>();

        ResponsableRayonList = (List<ResponsableRayon>) new StoreDAO().findByid((Integer) session.getAttribute("id_store")).getResponsableRayonsById();
//        System.out.println(session.getAttribute("id_store") + "ResponsablesRayonByStore");
//        System.out.println(store1.getNom());
//        System.out.println(store1.getNom());


        if (ResponsableRayonList.size() != 0) {
            ResponsableRayonList.forEach(ResponsableRayon -> System.out.println("Resp"+ ResponsableRayon.getName()));
            return ResponsableRayonList;

        }
        return null;
    }


    public boolean ajouterResponsable(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        System.out.println(request.getParameter("date_depart"));
//        get values
        AdminStoreServlet.error = new ArrayList<>();
        HttpSession session = request.getSession(false);
        responsableRayon.setIdCategorie(Integer.valueOf(request.getParameter("categorie")));
        responsableRayon.setIdStore((Integer) session.getAttribute("id_store"));
        responsableRayon.setName(request.getParameter("nom"));
        responsableRayon.setPass(request.getParameter("pass"));
        responsableRayon.setEmail(request.getParameter("email"));
        return new ResponsableRayonDAO().save(responsableRayon) != null;

    }
    public boolean supprimerResponsableRayon(HttpServletRequest request, HttpServletResponse response) {
        if ((responsableRayonDAO.delete(Long.parseLong(request.getParameter("id")))) != null) {
            System.out.println("test valide");
            return true;
        }
        System.out.println("test invalide");

        return false;
    }


    public boolean login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        responsableRayon.setPass(request.getParameter("pass"));
        responsableRayon.setEmail(request.getParameter("email"));
        responsableRayon = responsableRayonDAO.login(responsableRayon);
//           System.out.println(u:ser);
        if (responsableRayon != null) {

                HttpSession session = request.getSession();
                session.setAttribute("id", responsableRayon.getId());
                session.setAttribute("name", responsableRayon.getName());
                session.setAttribute("role", Enum.Role.RESPONSABLE.toString());
                session.setAttribute("id_store_respo", responsableRayon.getIdStore());

                response.sendRedirect("/ResponsableRayon");
                return true;


        }
        AuthServlet.error=new ArrayList<>();
        AuthServlet.error.add("erreur");
        response.sendRedirect("/Auth");

        return false;
    }

}
