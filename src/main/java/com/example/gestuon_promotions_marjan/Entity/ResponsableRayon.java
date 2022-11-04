package com.example.gestuon_promotions_marjan.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "responsable_rayon", schema = "public", catalog = "products_management")
public class ResponsableRayon {
    private int id;
    private String email;
    private Integer idCategorie;
    private Integer idStore;
    private String name;
    private String pass;
    private Categorie categorieByIdCategorie;
    private Store storeByIdStore;

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
    @Column(name = "email", nullable = true, length = -1)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "id_categorie", nullable = true)
    public Integer getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Integer idCategorie) {
        this.idCategorie = idCategorie;
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
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "pass", nullable = true, length = -1)
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }



    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_categorie", referencedColumnName = "id",insertable = false, updatable = false)
    public Categorie getCategorieByIdCategorie() {
        return categorieByIdCategorie;
    }

    public void setCategorieByIdCategorie(Categorie categorieByIdCategorie) {
        this.categorieByIdCategorie = categorieByIdCategorie;
    }

    @ManyToOne
    @JoinColumn(name = "id_store", referencedColumnName = "id",insertable = false, updatable = false)
    public Store getStoreByIdStore() {
        return storeByIdStore;
    }

    public void setStoreByIdStore(Store storeByIdStore) {
        this.storeByIdStore = storeByIdStore;
    }
}
