package com.example.gestuon_promotions_marjan.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "commentaires",schema = "public",catalog = "products_management")

public class Commentaires {
    private int id;
    private String commentaire;
    private Integer idPromo;
    private Promotion promotionByIdPromo;

    public Commentaires() {
    }

    public Commentaires(String commentaire, Integer idPromo) {
        this.commentaire = commentaire;
        this.idPromo = idPromo;
    }

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
    @Column(name = "commentaire", nullable = true, length = -1)
    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @Basic
    @Column(name = "id_promo", nullable = true)
    public Integer getIdPromo() {
        return idPromo;
    }

    public void setIdPromo(Integer idPromo) {
        this.idPromo = idPromo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Commentaires that = (Commentaires) o;

        if (id != that.id) return false;
        if (commentaire != null ? !commentaire.equals(that.commentaire) : that.commentaire != null) return false;
        if (idPromo != null ? !idPromo.equals(that.idPromo) : that.idPromo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (commentaire != null ? commentaire.hashCode() : 0);
        result = 31 * result + (idPromo != null ? idPromo.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_promo", referencedColumnName = "id",insertable = false, updatable = false)
    public Promotion getPromotionByIdPromo() {
        return promotionByIdPromo;
    }

    public void setPromotionByIdPromo(Promotion promotionByIdPromo) {
        this.promotionByIdPromo = promotionByIdPromo;
    }
}
