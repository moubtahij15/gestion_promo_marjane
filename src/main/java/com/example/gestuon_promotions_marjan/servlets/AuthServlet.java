package com.example.gestuon_promotions_marjan.servlets;

import com.example.gestuon_promotions_marjan.controllers.AdminController;
import com.example.gestuon_promotions_marjan.controllers.ResponsableController;
import com.example.gestuon_promotions_marjan.controllers.SuperAdminController;
import com.example.gestuon_promotions_marjan.helpers.Enum;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AuthServlet", value = "/Auth/*")
public class AuthServlet extends HttpServlet {
    public static ArrayList<String> error = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("from auth");
        System.out.println(request.getParameter("test"));
        System.out.println("get");
        String path = request.getRequestURI();

        System.out.println(path);
            request.setAttribute("error", error);

        if (path.endsWith("login")) {
//
            request.getRequestDispatcher("/views/SuperAdmin/loginSuperAdmin.jsp").forward(request, response);

        } else {

            request.setAttribute("error", error);
            request.getRequestDispatcher("/views/loginUser.jsp").forward(request, response);
//        error.add("A");
        }


//       response.sendRedirect("/views/loginUser.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
        String path = request.getRequestURI();

//        User user = new User();
//        user.setPass(request.getParameter("pass"));
//        user.setEmail(request.getParameter("email"));
//        user.setRole(request.getParameter("role"));
//
//        System.out.println(user.getPass());
//        System.out.println("post");
        if(request.getParameter("role")!=null){

        if (request.getParameter("role".toString()).equals(Enum.Role.ADMIN.toString())) {
            try {
                new AdminController().login(request, response);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else if (request.getParameter("role".toString()).equals(Enum.Role.RESPONSABLE.toString())) {
            try {
                new ResponsableController().login(request, response);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        }else{
            System.out.println("sd");
            try {
                new SuperAdminController().login(request, response);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }


    }
}
