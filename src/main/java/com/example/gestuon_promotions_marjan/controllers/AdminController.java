package com.example.gestuon_promotions_marjan.controllers;

import com.example.gestuon_promotions_marjan.DAO.CategorieDAO;
import com.example.gestuon_promotions_marjan.DAO.UserDAO;
import com.example.gestuon_promotions_marjan.Entity.User;
import com.example.gestuon_promotions_marjan.helpers.Hash;
import com.example.gestuon_promotions_marjan.helpers.SendMail;

public class AdminController {

    UserDAO userDAO;
    User user;

    public AdminController() {
        this.userDAO = new UserDAO();
    }

    boolean addRespo(User resp, int idCategoie) throws Exception {
        resp.setPass(Hash.MD5(resp.getPass()));
        return new CategorieDAO().asignCategorieRespnsable(idCategoie, userDAO.save(resp).getId());


    }

    boolean login(User resp) throws Exception {
        return userDAO.login(resp);
    }

}
