package com.example.gestuon_promotions_marjan.servlets;

import com.example.gestuon_promotions_marjan.Entity.Categorie;
import com.example.gestuon_promotions_marjan.Entity.Promotion;
import com.example.gestuon_promotions_marjan.Entity.ResponsableRayon;
import com.example.gestuon_promotions_marjan.Entity.SousCategorie;
import com.example.gestuon_promotions_marjan.controllers.CategorieController;
import com.example.gestuon_promotions_marjan.controllers.PromotionController;
import com.example.gestuon_promotions_marjan.controllers.ResponsableController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ResponsableRayon", value = "/ResponsableRayon/*")
public class ResponsableRayonServlet extends HttpServlet {
//    public static ArrayList<String> error = new ArrayList<>();
//    public static List<Promotion> promotions = new ArrayList<>();
//    public static List<ResponsableRayon> ResponsablesRayon = new ArrayList<>();
//    public static List<SousCategorie> sousCategorieList = new ArrayList<>();
//    public static List<Categorie> categorieList = new ArrayList<>();
//    boolean type_sous_categorie = false;

    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI();
        System.out.println(path);
//

        if (path.endsWith("RefuserPromo")) {
            if (new PromotionController().refusPromotion(request, response)) {
                response.sendRedirect("/ResponsableRayon");
            }
        }else {

            request.setAttribute("Promotions", new PromotionController().pendingPromotionByResponsable(request, response));
//            request.setAttribute("ResponsablesRayon", new ResponsableController().ResponsablesRayonByStore(request, response));
            request.getRequestDispatcher("/views/ResponsableStore/ResponsableRayonDashboard.jsp").forward(request, response);
//
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path = request.getRequestURI();

        if (path.endsWith("ValiderPromotion")) {
            if (new PromotionController().acceptPromotion(request, response)) {
                response.sendRedirect("/ResponsableRayon");

            }
        }

    }
}
