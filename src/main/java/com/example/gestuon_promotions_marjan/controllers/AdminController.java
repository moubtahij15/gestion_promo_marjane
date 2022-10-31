package com.example.gestuon_promotions_marjan.controllers;

import com.example.gestuon_promotions_marjan.DAO.CategorieDAO;
import com.example.gestuon_promotions_marjan.DAO.PromotionDAO;
import com.example.gestuon_promotions_marjan.DAO.UserDAO;
import com.example.gestuon_promotions_marjan.Entity.User;
import com.example.gestuon_promotions_marjan.helpers.Enum;
import com.example.gestuon_promotions_marjan.helpers.Hash;
import com.example.gestuon_promotions_marjan.helpers.JPA;
import com.example.gestuon_promotions_marjan.helpers.SendMail;
import com.example.gestuon_promotions_marjan.servlets.AdminStoreServlet;
import com.example.gestuon_promotions_marjan.servlets.AuthServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;

public class AdminController {

    UserDAO userDAO;
    User user;

    public AdminController() {
        this.userDAO = new UserDAO();
        this.user = new User();
    }

    boolean addRespo(User resp, int idCategoie) throws Exception {
        resp.setPass(Hash.MD5(resp.getPass()));
        return new CategorieDAO().asignCategorieRespnsable(idCategoie, userDAO.save(resp).getId());


    }

    public boolean login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        user.setPass(request.getParameter("pass"));
        user.setEmail(request.getParameter("email"));
        user.setRole(request.getParameter("role"));
        user = userDAO.login(user);
//           System.out.println(u:ser);
        if (user != null) {
            if (user.getRole().equals(Enum.Role.ADMIN.toString())) {
                HttpSession session = request.getSession();
                session.setAttribute("id", user.getId());
                session.setAttribute("name", user.getName());
                session.setAttribute("role", user.getRole());
                session.setAttribute("id_store", user.getIdStore());


                response.sendRedirect("/AdminStore");
                return true;
            }

        }
        AuthServlet.error=new ArrayList<>();
        AuthServlet.error.add("erreur");
        response.sendRedirect("/Auth");

        return false;
    }

}
