package com.example.gestuon_promotions_marjan.Entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Categorie {
    private int id;
    private String nom;
    private Collection<ResponsableRayon> responsableRayonsById;
    private Collection<CategorieStore> categorieStoresById;
    private Collection<Promotion> promotionsById;
    private Collection<SousCategorie> sousCategoriesById;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Categorie categorie = (Categorie) o;

        if (id != categorie.id) return false;
        if (nom != null ? !nom.equals(categorie.nom) : categorie.nom != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "categorieByIdCategorie")
    public Collection<ResponsableRayon> getResponsableRayonsById() {
        return responsableRayonsById;
    }

    public void setResponsableRayonsById(Collection<ResponsableRayon> responsableRayonsById) {
        this.responsableRayonsById = responsableRayonsById;
    }

    @OneToMany(mappedBy = "categorieByIdCategorie")
    public Collection<CategorieStore> getCategorieStoresById() {
        return categorieStoresById;
    }

    public void setCategorieStoresById(Collection<CategorieStore> categorieStoresById) {
        this.categorieStoresById = categorieStoresById;
    }

    @OneToMany(mappedBy = "categorieByIdCategorie")
    public Collection<Promotion> getPromotionsById() {
        return promotionsById;
    }

    public void setPromotionsById(Collection<Promotion> promotionsById) {
        this.promotionsById = promotionsById;
    }

    @OneToMany(mappedBy = "categorieByIdCategorie")
    public Collection<SousCategorie> getSousCategoriesById() {
        return sousCategoriesById;
    }

    public void setSousCategoriesById(Collection<SousCategorie> sousCategoriesById) {
        this.sousCategoriesById = sousCategoriesById;
    }
}
