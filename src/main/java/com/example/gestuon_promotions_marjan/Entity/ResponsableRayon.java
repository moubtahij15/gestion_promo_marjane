package com.example.gestuon_promotions_marjan.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "responsable_Rayon", schema = "public", catalog = "products_management")
public class ResponsableRayon {
    private int id;
    private String name;
    private String email;
    private String pass;
    private Integer idStore;
    private Integer idCategorie;
    private Store storeByIdStore;
    private Categorie categorieByIdCategorie;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public ResponsableRayon(String name, String email, String pass, Integer idStore) {
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.idStore = idStore;
    }

    public ResponsableRayon() {
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "email", nullable = true, length = -1)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "pass", nullable = true, length = -1)
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Basic
    @Column(name = "id_store", nullable = true)
    public Integer getIdStore() {
        return idStore;
    }

    public void setIdStore(Integer idStore) {
        this.idStore = idStore;
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

        ResponsableRayon that = (ResponsableRayon) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (pass != null ? !pass.equals(that.pass) : that.pass != null) return false;
        if (idStore != null ? !idStore.equals(that.idStore) : that.idStore != null) return false;
        if (idCategorie != null ? !idCategorie.equals(that.idCategorie) : that.idCategorie != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (pass != null ? pass.hashCode() : 0);
        result = 31 * result + (idStore != null ? idStore.hashCode() : 0);
        result = 31 * result + (idCategorie != null ? idCategorie.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_store", referencedColumnName = "id",insertable = false, updatable = false)
    public Store getStoreByIdStore() {
        return storeByIdStore;
    }

    public void setStoreByIdStore(Store storeByIdStore) {
        this.storeByIdStore = storeByIdStore;
    }

    @ManyToOne
    @JoinColumn(name = "id_categorie", referencedColumnName = "id",insertable = false, updatable = false)
    public Categorie getCategorieByIdCategorie() {
        return categorieByIdCategorie;
    }

    public void setCategorieByIdCategorie(Categorie categorieByIdCategorie) {
        this.categorieByIdCategorie = categorieByIdCategorie;
    }

    @Override
    public String toString() {
        return "ResponsableRayon{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", idStore=" + idStore +
                ", categorieByIdCategorie=" + categorieByIdCategorie.getNom() +
                '}';
    }
}
