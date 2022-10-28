package com.example.gestuon_promotions_marjan.controllers;

import com.example.gestuon_promotions_marjan.Entity.SuperAdmin;
import com.example.gestuon_promotions_marjan.Entity.User;
import com.example.gestuon_promotions_marjan.helpers.Enum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminControllerTest {
    AdminController adminController = new AdminController();


    @Test
    void addRespo() throws Exception {
        User a = new User();
        a.setEmail("otman2.com");
        a.setPass("admin");
        a.setIdStore(3);
        a.setRole(Enum.Role.RESPONSABLE.toString());
        assertTrue(adminController.addRespo(a, 4));
    }

    @Test
    void login() throws Exception {
        User user = new User();
        user.setEmail("otman2.com");
        user.setPass("admin");
        user.setRole(Enum.Role.RESPONSABLE.toString());
        assertTrue(adminController.login(user));
    }
}