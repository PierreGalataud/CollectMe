package com.example.collectme.Entity;

import java.util.ArrayList;
import java.util.List;

public class Category {

    private String id;
    private String nom;

    private List<Article> listArticle;

    public Category(String id, String nom) {
        this.id = id;
        this.nom = nom;
        listArticle = new ArrayList<>();
    }

    public Category() {
    }

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

    public void addArticle(Article article){
        listArticle.add(article);
    }

    public void removeArticle(Article article){
        listArticle.remove(article);
    }

    public List<Article> getListArticle() {
        return listArticle;
    }
}
