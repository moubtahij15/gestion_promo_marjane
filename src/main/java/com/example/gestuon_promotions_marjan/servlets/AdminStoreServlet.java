package com.example.gestuon_promotions_marjan.servlets;

import com.example.gestuon_promotions_marjan.Entity.Promotion;
import com.example.gestuon_promotions_marjan.controllers.PromotionController;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AdminStoreServlet", value = "/AdminStore/*")
public class AdminStoreServlet extends HttpServlet {
    public static List<Promotion> promotions = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        promotions = new PromotionController().promotionByStore(user.getIdStore());
        promotions = new PromotionController().promotionByStore(request, response);
        promotions.forEach(promotion -> System.out.println(promotion.getStatut()));
//        System.out.println("promotions.get(0).getId()");
        request.setAttribute("Promotions", promotions);

        request.getRequestDispatcher("/views/AdminStore/dashboardResponsable.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
