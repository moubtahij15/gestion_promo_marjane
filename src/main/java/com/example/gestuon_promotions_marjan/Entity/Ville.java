package com.example.gestuon_promotions_marjan.Entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Ville {
    private int id;
    private String nom;
    private Collection<Store> storesById;

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

        Ville ville = (Ville) o;

        if (id != ville.id) return false;
        if (nom != null ? !nom.equals(ville.nom) : ville.nom != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "villeByIdVille")
    public Collection<Store> getStoresById() {
        return storesById;
    }

    public void setStoresById(Collection<Store> storesById) {
        this.storesById = storesById;
    }
}
