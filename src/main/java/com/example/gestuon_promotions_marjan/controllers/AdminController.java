package com.example.gestuon_promotions_marjan.controllers;

import com.example.gestuon_promotions_marjan.DAO.UserDAO;
import com.example.gestuon_promotions_marjan.Entity.User;
import com.example.gestuon_promotions_marjan.helpers.SendMail;

public class AdminController {

    UserDAO userDAO;
    User user;

    public AdminController() {
        this.userDAO = new UserDAO();
    }
    void addRespo(User resp) {
        userDAO.save(resp);
        String confirmMsg = "email : " + resp.getEmail() + "\n pass : " + resp.getPass();
        SendMail.sendMessage(resp.getEmail(), "Confirmation reservation", confirmMsg);
    }

    void login(User resp) throws Exception {
        if (userDAO.login(resp)) {
            System.out.println("Bien passer");
//            System.out.println(new PromotionDAO().findAll());
        } else {
            System.out.println("no");
        }
    }

}
