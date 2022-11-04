package com.example.gestuon_promotions_marjan.Entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

@Entity
public class Store {
    private int id;
    private String nom;
    private Integer idVille;
    private Collection<Promotion> promotionsById;
    private Collection<ResponsableRayon> responsableRayonsById;
    private Ville villeByIdVille;
    private Collection<User> usersById;
    private List<Categorie> categoriesById;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nom", nullable = true, length = -1)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "id_ville", nullable = true)
    public Integer getIdVille() {
        return idVille;
    }

    public void setIdVille(Integer idVille) {
        this.idVille = idVille;
    }

    @ManyToMany(mappedBy = "storeById")
    public List<Categorie> getCategoriesById() {
        return categoriesById;
    }

    public void setCategoriesById(List<Categorie> categoriesById) {
        this.categoriesById = categoriesById;
    }

    @OneToMany(mappedBy = "storeByIdStore")
    public Collection<Promotion> getPromotionsById() {
        return promotionsById;
    }

    public void setPromotionsById(Collection<Promotion> promotionsById) {
        this.promotionsById = promotionsById;
    }

    @OneToMany(mappedBy = "storeByIdStore")
    public Collection<ResponsableRayon> getResponsableRayonsById() {
        return responsableRayonsById;
    }

    public void setResponsableRayonsById(Collection<ResponsableRayon> responsableRayonsById) {
        this.responsableRayonsById = responsableRayonsById;
    }

    @ManyToOne
    @JoinColumn(name = "id_ville", referencedColumnName = "id", insertable = false, updatable = false)
    public Ville getVilleByIdVille() {
        return villeByIdVille;
    }

    public void setVilleByIdVille(Ville villeByIdVille) {
        this.villeByIdVille = villeByIdVille;
    }

    @OneToMany(mappedBy = "storeByIdStore")
    public Collection<User> getUsersById() {
        return usersById;
    }

    public void setUsersById(Collection<User> usersById) {
        this.usersById = usersById;
    }
}
