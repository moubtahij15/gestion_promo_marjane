package com.example.gestuon_promotions_marjan.DAO;

import com.example.gestuon_promotions_marjan.Entity.User;
import com.example.gestuon_promotions_marjan.helpers.Hash;
import com.example.gestuon_promotions_marjan.helpers.JPA;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IDAO<User> {
    @Override
//    @Transactional
    public void save(User user) {
        JPA.serv(em -> em.persist(user));
    }


    @Override
    public List<User> findAll() {
        Query query = JPA.entityManager().createQuery("select user from User user ");
        return query.getResultList();
    }

    @Override
    public List<User> findByDesignation(String mc) {
        Query query = JPA.entityManager().createQuery("select user from User user where user.role=:role");
        query.setParameter("role", "Fritz");
        return query.getResultList();
    }

    public List<User> findByRole(String role) {
        Query query = JPA.entityManager().createQuery("select user from User user where user.role=:role");
        query.setParameter("role", role);
//        query.stream
        List<User> userList = (List<User>) query.getResultList().stream();
        return userList;
    }

    public void displayUser(ArrayList<User> userArrayList) {
        for (User currentUser : userArrayList) {
            System.out.println("User {" + currentUser.getId()
                    + " , name='" + currentUser.getName() + '\'' +
                    ", email='" + currentUser.getEmail() + '\'' +
                    ", le nom du store=" + currentUser.getStoreByIdStore().getNom() + '\'' +
                    ", la ville=" + currentUser.getStoreByIdStore().getVilleByIdVille().getNom() + '\'' +
                    '}');
        }

    }

    @Override
    public User findByid(long id) {

        return JPA.entityManager().find(User.class, id);
    }


    @Override
    public void update(User produit) {
        JPA.serv(em->em.merge(produit));
    }

    @Override
    public void delete(long id) {

            User p = JPA.entityManager().find(User.class, id);
            JPA.serv(entityManager -> entityManager.remove(p));
    }


    public boolean login(User user) throws Exception {
        User user1 = new User();
        Query query = JPA.entityManager().createQuery("select user from User user where user.role=:role and user.email=:email");
        query.setParameter("role", user.getRole());
        query.setParameter("email", user.getEmail());
        user1 = (User) query.getResultList();
//
        if (user != null && Hash.MD5(user.getPass()).equals(user1.getPass())) {
            return true;
        }
        return false;
    }
}



