package com.example.gestuon_promotions_marjan.servlets;

import com.example.gestuon_promotions_marjan.controllers.PromotionController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AdminGeneral", value = "/AdminGeneral/*")
public class AdminGeneralServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI();
        System.out.println(path);

        request.setAttribute("Promotions", new PromotionController().allPromotion(request, response));

        request.getRequestDispatcher("/views/SuperAdmin/AdminGeneralDashboard.jsp").forward(request, response);




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
