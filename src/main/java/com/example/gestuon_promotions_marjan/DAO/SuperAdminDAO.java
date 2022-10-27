package com.example.gestuon_promotions_marjan.DAO;

import com.example.gestuon_promotions_marjan.Entity.SuperAdmin;
import com.example.gestuon_promotions_marjan.helpers.Hash;
import com.example.gestuon_promotions_marjan.helpers.JPA;
import jakarta.persistence.Query;

public class SuperAdminDAO {

    public boolean login(SuperAdmin superAdmin) throws Exception {
        SuperAdmin superAdmin1 = new SuperAdmin();
        Query query = JPA.entityManager().createQuery("select superAdmin from SuperAdmin superAdmin where  superAdmin.email=:email");
        query.setParameter("email", superAdmin.getEmail());

        superAdmin1 = (SuperAdmin) query.getSingleResult();
        System.out.println(superAdmin1.getEmail());
        if (superAdmin1 != null && Hash.MD5(superAdmin.getPass()).equals(superAdmin1.getPass())) {
            return true;
        }
        return false;
    }
}
