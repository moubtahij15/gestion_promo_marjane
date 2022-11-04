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
    public User save(User user) {
       new JPA().serv(em -> em.persist(user));
        return user;
    }

    public User saves(User user) {
        new JPA().serv(em -> em.persist(user));
        return user;
    }


    @Override
    public List<User> findAll() {
        Query query =  new JPA().getEm().createQuery("select user from User user ");
        return query.getResultList();
    }

    @Override
    public List<User> findByDesignation(String mc) {
        Query query =  new JPA().getEm().createQuery("select user from User user where user.role=:role");
        query.setParameter("role", "Fritz");
        return query.getResultList();
    }

    public List<User> findByRole(String role) {
        Query query =  new JPA().getEm().createQuery("select user from User user where user.role=:role");
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
    public User findByid(int id) {

        return  new JPA().getEm().find(User.class, id);
    }


    @Override
    public User update(User user) {
         new JPA().serv(em -> em.merge(user));
        return user;
    }

    @Override
    public User delete(long id) {

        User p  =new JPA().getEm().find(User.class, id);
       new  JPA().serv(entityManager -> entityManager.remove(p));
        return p;
    }


    public User login(User user) throws Exception {
        User user1 = new User();
        try {

            Query query =  new JPA().getEm().createQuery("select user from User user where  user.email=:email");
            query.setParameter("email", user.getEmail());
            user1 = (User) query.getSingleResult();
            System.out.println("LOGIN 1");

        } catch (Exception e) {

            return null;
        }

//
        if (user1 != null && Hash.MD5(user.getPass()).equals(user1.getPass())) {
            System.out.println("LOGIN 2");
            return user1;
        }
        return null;
    }
}



