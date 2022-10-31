package com.example.gestuon_promotions_marjan.servlets;

import com.example.gestuon_promotions_marjan.Entity.User;
import com.example.gestuon_promotions_marjan.controllers.AdminController;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AuthServlet", value = "/Auth")
public class AuthServlet extends HttpServlet {
    public static   ArrayList<String> error = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("error", error);

        request.getRequestDispatcher("/views/loginUser.jsp").forward(request, response);
//        error.add("A");

//       response.sendRedirect("/views/loginUser.jsp");
        System.out.println("get");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = new User();
        user.setPass(request.getParameter("pass"));
        user.setEmail(request.getParameter("email"));
        user.setRole(request.getParameter("role"));

        System.out.println(user.getPass());
        System.out.println("post");

        try {
            new AdminController().login(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
