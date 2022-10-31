package com.example.gestuon_promotions_marjan.Entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "user", schema = "public", catalog = "products_management")
public class User {
    private int id;
    private String name;
    private String email;
    private String pass;
    private Integer idStore;
    private String role;
    private Collection<Categorie> categoriesById;
    private Store storeByIdStore;

    public User(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }

    public User() {
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
    @Column(name = "role", nullable = true, length = -1)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (pass != null ? !pass.equals(user.pass) : user.pass != null) return false;
        if (idStore != null ? !idStore.equals(user.idStore) : user.idStore != null) return false;
        if (role != null ? !role.equals(user.role) : user.role != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (pass != null ? pass.hashCode() : 0);
        result = 31 * result + (idStore != null ? idStore.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userByIdRespo")
    public Collection<Categorie> getCategoriesById() {
        return categoriesById;
    }

    public void setCategoriesById(Collection<Categorie> categoriesById) {
        this.categoriesById = categoriesById;
    }

    @ManyToOne
    @JoinColumn(name = "id_store", referencedColumnName = "id", insertable = false, updatable = false)
    public Store getStoreByIdStore() {
        return storeByIdStore;
    }

    public void setStoreByIdStore(Store storeByIdStore) {
        this.storeByIdStore = storeByIdStore;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
