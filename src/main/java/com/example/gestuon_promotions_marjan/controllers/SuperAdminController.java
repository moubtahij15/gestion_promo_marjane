package com.example.gestuon_promotions_marjan.controllers;

import com.example.gestuon_promotions_marjan.DAO.UserDAO;
import com.example.gestuon_promotions_marjan.DAO.SuperAdminDAO;
import com.example.gestuon_promotions_marjan.Entity.SuperAdmin;
import com.example.gestuon_promotions_marjan.Entity.User;
import com.example.gestuon_promotions_marjan.helpers.Enum;
import com.example.gestuon_promotions_marjan.helpers.SendMail;
import com.example.gestuon_promotions_marjan.servlets.AuthServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;


public class SuperAdminController {
    UserDAO userDAO;
    SuperAdminDAO superAdminDAO;
    SuperAdmin superAdmin;
    User user;

    public SuperAdminController() {
        this.userDAO = new UserDAO();
        this.superAdminDAO = new SuperAdminDAO();
        this.superAdmin = new SuperAdmin();
    }

    boolean addAdmin(User admin) {
        if ((userDAO.save(admin) != null)) {
            String confirmMsg = "email : " + admin.getEmail() + "\n pass : " + admin.getPass();
            SendMail.sendMessage(admin.getEmail(), "Confirmation reservation", confirmMsg);
            return true;
        }
        return false;
    }

//    boolean login(SuperAdmin superAdmin) throws Exception {
//        if (superAdminDAO.login(superAdmin)) {
//            return true;
//        } else {
//            return false;
//        }
//    }

    public boolean login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        superAdmin.setPass(request.getParameter("pass"));
        superAdmin.setEmail(request.getParameter("email"));
        superAdmin = superAdminDAO.login(superAdmin);
//           System.out.println(u:ser);
        if (superAdmin != null) {
            HttpSession session = request.getSession();
            session.setAttribute("id", superAdmin.getId());
            session.setAttribute("name", superAdmin.getName());
            response.sendRedirect("/AdminGeneral");
            System.out.println("ok");
            return true;


        }
        AuthServlet.error = new ArrayList<>();
        AuthServlet.error.add("erreur");
        System.out.println("not");
        response.sendRedirect("/Auth/login");

        return false;
    }


}
