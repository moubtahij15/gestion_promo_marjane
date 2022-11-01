package com.example.gestuon_promotions_marjan.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "categorie_store", schema = "public", catalog = "products_management")
@IdClass(CategorieStorePK.class)
public class CategorieStore {
    private int idCategorie;
    private int idStore;
    private Categorie categorieByIdCategorie;
    private Store storeByIdStore;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_categorie", nullable = false)
    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_store", nullable = false)
    public int getIdStore() {
        return idStore;
    }

    public void setIdStore(int idStore) {
        this.idStore = idStore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategorieStore that = (CategorieStore) o;

        if (idCategorie != that.idCategorie) return false;
        if (idStore != that.idStore) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCategorie;
        result = 31 * result + idStore;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_categorie", referencedColumnName = "id", nullable = false,insertable = false, updatable = false)
    public Categorie getCategorieByIdCategorie() {
        return categorieByIdCategorie;
    }

    public void setCategorieByIdCategorie(Categorie categorieByIdCategorie) {
        this.categorieByIdCategorie = categorieByIdCategorie;
    }

    @ManyToOne
    @JoinColumn(name = "id_store", referencedColumnName = "id", nullable = false,insertable = false, updatable = false)
    public Store getStoreByIdStore() {
        return storeByIdStore;
    }

    public void setStoreByIdStore(Store storeByIdStore) {
        this.storeByIdStore = storeByIdStore;
    }
}
