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
        this.superAdminDAO=new SuperAdminDAO();
    }

    void addAdmin(User admin) {
        userDAO.save(admin);
        String confirmMsg = "email : " + admin.getEmail() + "\n pass : " + admin.getPass();
        SendMail.sendMessage(admin.getEmail(), "Confirmation reservation", confirmMsg);
    }

    void login(SuperAdmin superAdmin) throws Exception {
        if (superAdminDAO.login(superAdmin)) {
            System.out.println("ok");
            System.out.println(new PromotionDAO().findAll());
        } else {
            System.out.println("no");
        }
    }

    public static void main(String[] args) throws Exception {
            SuperAdminController sp = new SuperAdminController();
            SuperAdmin a = new SuperAdmin();
            a.setEmail("otman@gmail.com");
            a.setPass("admin");
            sp.login(a);
    }







}
