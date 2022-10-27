package com.example.gestuon_promotions_marjan.Entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Store {
    private int id;
    private String nom;
    private Integer idVille;
    private Collection<Promotion> promotionsById;
    private Ville villeByIdVille;
    private Collection<User> usersById;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Store store = (Store) o;

        if (id != store.id) return false;
        if (nom != null ? !nom.equals(store.nom) : store.nom != null) return false;
        if (idVille != null ? !idVille.equals(store.idVille) : store.idVille != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (idVille != null ? idVille.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "storeByIdStore")
    public Collection<Promotion> getPromotionsById() {
        return promotionsById;
    }

    public void setPromotionsById(Collection<Promotion> promotionsById) {
        this.promotionsById = promotionsById;
    }

    @ManyToOne
    @JoinColumn(name = "id_ville", referencedColumnName = "id",insertable = false, updatable = false)
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
