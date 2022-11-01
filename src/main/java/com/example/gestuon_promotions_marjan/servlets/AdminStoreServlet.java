package com.example.gestuon_promotions_marjan.servlets;

import com.example.gestuon_promotions_marjan.Entity.Promotion;
import com.example.gestuon_promotions_marjan.Entity.ResponsableRayon;
import com.example.gestuon_promotions_marjan.controllers.PromotionController;
import com.example.gestuon_promotions_marjan.controllers.ResponsableController;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AdminStoreServlet", value = "/AdminStore/*")
public class AdminStoreServlet extends HttpServlet {
    public static List<Promotion> promotions = new ArrayList<>();
    public static List<ResponsableRayon> ResponsablesRayon = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        promotions = new PromotionController().promotionByStore(user.getIdStore());
        promotions = new PromotionController().promotionByStore(request, response);
        ResponsablesRayon= new ResponsableController().ResponsablesRayonByStore(request,response);
        request.setAttribute("Promotions", promotions);
        request.setAttribute("ResponsablesRayon", ResponsablesRayon);

        request.getRequestDispatcher("/views/AdminStore/dashboardResponsable.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
