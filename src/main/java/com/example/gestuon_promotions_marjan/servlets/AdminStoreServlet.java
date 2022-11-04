package com.example.gestuon_promotions_marjan.servlets;

import com.example.gestuon_promotions_marjan.DAO.ResponsableRayonDAO;
import com.example.gestuon_promotions_marjan.Entity.Categorie;
import com.example.gestuon_promotions_marjan.Entity.Promotion;
import com.example.gestuon_promotions_marjan.Entity.ResponsableRayon;
import com.example.gestuon_promotions_marjan.Entity.SousCategorie;
import com.example.gestuon_promotions_marjan.controllers.CategorieController;
import com.example.gestuon_promotions_marjan.controllers.PromotionController;
import com.example.gestuon_promotions_marjan.controllers.ResponsableController;
import com.example.gestuon_promotions_marjan.helpers.JPA;
import jakarta.persistence.Persistence;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AdminStoreServlet", value = "/AdminStore/*")
public class AdminStoreServlet extends HttpServlet {
    public static ArrayList<String> error = new ArrayList<>();
    public static List<Promotion> promotions = new ArrayList<>();
    public static List<ResponsableRayon> ResponsablesRayon = new ArrayList<>();
    public static List<SousCategorie> sousCategorieList = new ArrayList<>();
    public static List<Categorie> categorieList = new ArrayList<>();
    boolean type_sous_categorie = false;

    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI();
        System.out.println(path);
//        promotions = new PromotionController().promotionByStore(request, response);
//        ResponsablesRayon = new ResponsableController().ResponsablesRayonByStore(request, response);
//        categorieList = new CategorieController().AllcategorieByStore(request, response);


        if (path.endsWith("deletePromo")) {
            System.out.println("deletePromo");
            if (new PromotionController().supprimerPromotion(request, response)) {
//                promotions = new ArrayList<>();
                System.out.println("ss");
                response.sendRedirect("/AdminStore");

            }

        } else if (path.endsWith("Responsable")) {
            System.out.println("Responsable");
            request.setAttribute("FreeCategorieList", new CategorieController().FreeCategorieByStore(request, response));
            request.setAttribute("ResponsablesRayon", new ResponsableController().ResponsablesRayonByStore(request, response));
            request.getRequestDispatcher("/views/AdminStore/ResponsableRayon.jsp").forward(request, response);

        } else if (path.endsWith("delete")) {
            System.out.println("deleteResponsable");
            if (new ResponsableController().supprimerResponsableRayon(request, response)) {
//                promotions = new ArrayList<>();
                response.sendRedirect("/AdminStore/Responsable");

            }
        } else {

            int categorieId = 0;


            request.setAttribute("erreur", error);

//        condition pour charger les sous categories selon la categorie choisi
            if (path.endsWith("sousCategorie")) {
                categorieId = Integer.parseInt(request.getParameter("selected_categorie"));
                int finalCategorieId = categorieId;
                sousCategorieList = (List<SousCategorie>) categorieList.stream()
                        .filter(categorie -> categorie.getId() == finalCategorieId)
                        .findFirst().get().getSousCategoriesById();
                this.type_sous_categorie = true;
                sousCategorieList.forEach(sousCategorie -> System.out.println(sousCategorie.getNom()));
            }
            request.setAttribute("selectedCategorie", categorieId);
            request.setAttribute("type_sous_categorie", type_sous_categorie);
            request.setAttribute("souCategoeie", sousCategorieList);
            request.setAttribute("categorieList", new CategorieController().AllcategorieByStore(request, response));
            request.setAttribute("Promotions", new PromotionController().promotionByStore(request, response));
            request.setAttribute("ResponsablesRayon", new ResponsableController().ResponsablesRayonByStore(request, response));
            request.getRequestDispatcher("/views/AdminStore/dashboardResponsable.jsp").forward(request, response);

        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path = request.getRequestURI();
        if (path.endsWith("addPromo")) {
            this.type_sous_categorie = !(new PromotionController().ajouterPromotion(request, response));
            promotions = new ArrayList<>();
            response.sendRedirect("/AdminStore");
        } else if (path.endsWith("addResponsable")) {
            if (new ResponsableController().ajouterResponsable(request, response)) {
                ResponsablesRayon = new ArrayList<>();
                response.sendRedirect("/AdminStore/Responsable");
            }


        }


    }
}
