package com.example.collectme.Entity;

import java.util.List;

public class Category {

    private String id;
    private String nom;

    private List<Article> listArticle;

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
}
