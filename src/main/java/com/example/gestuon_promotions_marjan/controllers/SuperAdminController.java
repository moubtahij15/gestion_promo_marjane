package com.example.gestuon_promotions_marjan.controllers;

import com.example.gestuon_promotions_marjan.DAO.UserDAO;
import com.example.gestuon_promotions_marjan.DAO.PromotionDAO;
import com.example.gestuon_promotions_marjan.DAO.SuperAdminDAO;
import com.example.gestuon_promotions_marjan.Entity.SuperAdmin;
import com.example.gestuon_promotions_marjan.Entity.User;
import com.example.gestuon_promotions_marjan.helpers.SendMail;


public class SuperAdminController {
    UserDAO userDAO;
    SuperAdminDAO superAdminDAO;
    User user;

    public SuperAdminController() {
        this.userDAO = new UserDAO();
        this.superAdminDAO = new SuperAdminDAO();
    }

    boolean addAdmin(User admin) {
        if ((userDAO.save(admin) != null)) {
            String confirmMsg = "email : " + admin.getEmail() + "\n pass : " + admin.getPass();
            SendMail.sendMessage(admin.getEmail(), "Confirmation reservation", confirmMsg);
            return true;
        }
        return false;
    }

    boolean login(SuperAdmin superAdmin) throws Exception {
        if (superAdminDAO.login(superAdmin)) {
            return true;
        } else {
            return false;
        }
    }


}
