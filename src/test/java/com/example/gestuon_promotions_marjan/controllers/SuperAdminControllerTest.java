package com.example.gestuon_promotions_marjan.controllers;

import com.example.gestuon_promotions_marjan.Entity.SuperAdmin;
import com.example.gestuon_promotions_marjan.Entity.User;
import com.example.gestuon_promotions_marjan.helpers.Enum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuperAdminControllerTest {
    SuperAdminController superAdminController = new SuperAdminController();

    @Test
    void addAdmin() throws Exception {
        User a = new User();
        a.setEmail("otman.moubtahij15@gmail.com");
        a.setPass("admin");
        a.setIdStore(3);
        a.setRole(Enum.Role.ADMIN.toString());
        assertTrue(superAdminController.addAdmin(a));

    }

    @Test
    void login() throws Exception {
        SuperAdmin superAdmin = new SuperAdmin();
        superAdmin.setEmail("otman@gmail.com");
        superAdmin.setPass("asdmin");
        assertTrue(superAdminController.login(superAdmin));


    }
}