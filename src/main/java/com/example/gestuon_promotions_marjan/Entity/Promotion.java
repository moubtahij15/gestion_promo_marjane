package com.example.gestuon_promotions_marjan.Entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
public class Promotion {
    private int id;
    private Double poucentage;
    private String type;
    private Date dateDebut;
    private Date dateFin;
    private Integer idCategorie;
    private Integer idSousCategorie;
    private Integer idStore;
    private String statut;
    private Collection<Commentaires> commentairesById;
    private Categorie categorieByIdCategorie;
    private SousCategorie sousCategorieByIdSousCategorie;
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
    @Column(name = "poucentage", nullable = true, precision = 0)
    public Double getPoucentage() {
        return poucentage;
    }

    public void setPoucentage(Double poucentage) {
        this.poucentage = poucentage;
    }

    @Basic
    @Column(name = "type", nullable = true, length = -1)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "date_debut", nullable = true)
    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    @Basic
    @Column(name = "date_fin", nullable = true)
    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
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
    @Column(name = "id_sous_categorie", nullable = true)
    public Integer getIdSousCategorie() {
        return idSousCategorie;
    }

    public void setIdSousCategorie(Integer idSousCategorie) {
        this.idSousCategorie = idSousCategorie;
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
    @Column(name = "statut", nullable = true, length = -1)
    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Promotion promotion = (Promotion) o;

        if (id != promotion.id) return false;
        if (poucentage != null ? !poucentage.equals(promotion.poucentage) : promotion.poucentage != null) return false;
        if (type != null ? !type.equals(promotion.type) : promotion.type != null) return false;
        if (dateDebut != null ? !dateDebut.equals(promotion.dateDebut) : promotion.dateDebut != null) return false;
        if (dateFin != null ? !dateFin.equals(promotion.dateFin) : promotion.dateFin != null) return false;
        if (idCategorie != null ? !idCategorie.equals(promotion.idCategorie) : promotion.idCategorie != null)
            return false;
        if (idSousCategorie != null ? !idSousCategorie.equals(promotion.idSousCategorie) : promotion.idSousCategorie != null)
            return false;
        if (idStore != null ? !idStore.equals(promotion.idStore) : promotion.idStore != null) return false;
        if (statut != null ? !statut.equals(promotion.statut) : promotion.statut != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (poucentage != null ? poucentage.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (dateDebut != null ? dateDebut.hashCode() : 0);
        result = 31 * result + (dateFin != null ? dateFin.hashCode() : 0);
        result = 31 * result + (idCategorie != null ? idCategorie.hashCode() : 0);
        result = 31 * result + (idSousCategorie != null ? idSousCategorie.hashCode() : 0);
        result = 31 * result + (idStore != null ? idStore.hashCode() : 0);
        result = 31 * result + (statut != null ? statut.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "promotionByIdPromo")
    public Collection<Commentaires> getCommentairesById() {
        return commentairesById;
    }

    public void setCommentairesById(Collection<Commentaires> commentairesById) {
        this.commentairesById = commentairesById;
    }

    @ManyToOne
    @JoinColumn(name = "id_categorie", referencedColumnName = "id",insertable = false, updatable = false)
    public Categorie getCategorieByIdCategorie() {
        return categorieByIdCategorie;
    }

    public void setCategorieByIdCategorie(Categorie categorieByIdCategorie) {
        this.categorieByIdCategorie = categorieByIdCategorie;
    }

    @ManyToOne
    @JoinColumn(name = "id_sous_categorie", referencedColumnName = "id",insertable = false, updatable = false)
    public SousCategorie getSousCategorieByIdSousCategorie() {
        return sousCategorieByIdSousCategorie;
    }

    public void setSousCategorieByIdSousCategorie(SousCategorie sousCategorieByIdSousCategorie) {
        this.sousCategorieByIdSousCategorie = sousCategorieByIdSousCategorie;
    }

    @ManyToOne
    @JoinColumn(name = "id_store", referencedColumnName = "id",insertable = false, updatable = false)
    public Store getStoreByIdStore() {
        return storeByIdStore;
    }

    public void setStoreByIdStore(Store storeByIdStore) {
        this.storeByIdStore = storeByIdStore;
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "id=" + id +
                ", poucentage=" + poucentage +
                ", type='" + type + '\'' +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", idCategorie=" + idCategorie +
                ", idSousCategorie=" + idSousCategorie +
                ", idStore=" + idStore +
                ", statut='" + statut + '\'' +
                '}';
    }
}
