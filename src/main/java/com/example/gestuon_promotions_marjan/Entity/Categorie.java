package com.example.gestuon_promotions_marjan.Entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

@Entity
public class Categorie {
    private int id;
    private String nom;
    private Collection<Promotion> promotionsById;
    private ResponsableRayon responsableRayonsById;
    private Collection<SousCategorie> sousCategoriesById;

    private List<Store> storeById;

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

    @ManyToMany(targetEntity = Store.class, cascade = {CascadeType.ALL})
    @JoinTable(
            name = "categorie_store",
            joinColumns = {@JoinColumn(name = "id_categorie", insertable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "id_store", insertable = false, updatable = false)}
    )
    public List<Store> getStoreById() {
        return storeById;
    }

    public void setStoreById(List<Store> storeById) {
        this.storeById = storeById;
    }

    @OneToMany(mappedBy = "categorieByIdCategorie")
    public Collection<Promotion> getPromotionsById() {
        return promotionsById;
    }

    public void setPromotionsById(Collection<Promotion> promotionsById) {
        this.promotionsById = promotionsById;
    }

    @OneToOne(mappedBy = "categorieByIdCategorie")

    public ResponsableRayon getResponsableRayonsById() {
        return responsableRayonsById;
    }

    public void setResponsableRayonsById(ResponsableRayon responsableRayonsById) {
        this.responsableRayonsById = responsableRayonsById;
    }

    @OneToMany(mappedBy = "categorieByIdCategorie")
    public Collection<SousCategorie> getSousCategoriesById() {
        return sousCategoriesById;
    }

    public void setSousCategoriesById(Collection<SousCategorie> sousCategoriesById) {
        this.sousCategoriesById = sousCategoriesById;
    }
}
