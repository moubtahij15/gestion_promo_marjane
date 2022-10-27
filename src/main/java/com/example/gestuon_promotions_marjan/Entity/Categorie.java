package com.example.gestuon_promotions_marjan.Entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "categorie",schema = "public",catalog = "products_management")
public class Categorie {
    private int id;
    private String nom;
    private Integer idRespo;
    private User userByIdRespo;
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

    @Basic
    @Column(name = "id_respo", nullable = true)
    public Integer getIdRespo() {
        return idRespo;
    }

    public void setIdRespo(Integer idRespo) {
        this.idRespo = idRespo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Categorie categorie = (Categorie) o;

        if (id != categorie.id) return false;
        if (nom != null ? !nom.equals(categorie.nom) : categorie.nom != null) return false;
        if (idRespo != null ? !idRespo.equals(categorie.idRespo) : categorie.idRespo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (idRespo != null ? idRespo.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_respo", referencedColumnName = "id",insertable = false, updatable = false)
    public User getUserByIdRespo() {
        return userByIdRespo;
    }

    public void setUserByIdRespo(User userByIdRespo) {
        this.userByIdRespo = userByIdRespo;
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
