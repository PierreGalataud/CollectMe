package com.example.collectme.Entity;

import java.util.List;

public class User {
    private String id;
    private String email;
    private String mdp;
    private List<Article> listarticle;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public List<Article> getListarticle() {
        return listarticle;
    }

    public void setListarticle(List<Article> listarticle) {
        this.listarticle = listarticle;
    }
}
