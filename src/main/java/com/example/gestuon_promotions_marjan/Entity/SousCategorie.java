package com.example.gestuon_promotions_marjan.Entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "sous_categorie", schema = "public", catalog = "products_management")
public class SousCategorie {
    private int id;
    private String nom;
    private Integer idCategorie;
    private Collection<Promotion> promotionsById;
    private Categorie categorieByIdCategorie;

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
    @Column(name = "id_categorie", nullable = true)
    public Integer getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Integer idCategorie) {
        this.idCategorie = idCategorie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SousCategorie that = (SousCategorie) o;

        if (id != that.id) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (idCategorie != null ? !idCategorie.equals(that.idCategorie) : that.idCategorie != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (idCategorie != null ? idCategorie.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "sousCategorieByIdSousCategorie")
    public Collection<Promotion> getPromotionsById() {
        return promotionsById;
    }

    public void setPromotionsById(Collection<Promotion> promotionsById) {
        this.promotionsById = promotionsById;
    }

    @ManyToOne
    @JoinColumn(name = "id_categorie", referencedColumnName = "id",insertable = false, updatable = false)
    public Categorie getCategorieByIdCategorie() {
        return categorieByIdCategorie;
    }

    public void setCategorieByIdCategorie(Categorie categorieByIdCategorie) {
        this.categorieByIdCategorie = categorieByIdCategorie;
    }
}
