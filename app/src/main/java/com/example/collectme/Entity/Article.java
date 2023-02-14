package com.example.collectme.Entity;

import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseUser;

public class Article {
    private String id;
    private String nom;
    private String description;
    private Timestamp date;
    private Category category;
    private FirebaseUser user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public FirebaseUser getUser() {
        return user;
    }

    public void setUser(FirebaseUser user){
        this.user = user;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", category=" + category +
                ", user=" + user +
                '}';
    }
}
