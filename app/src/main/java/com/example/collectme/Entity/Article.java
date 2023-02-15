package com.example.collectme.Entity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseUser;

import java.io.Serializable;

public class Article implements Parcelable {
    private String id;
    private String nom;
    private String description;
    private Timestamp date;
    private Category category;
    private FirebaseUser user;

    protected Article(Parcel in) {
        id = in.readString();
        nom = in.readString();
        description = in.readString();
        date = in.readParcelable(Timestamp.class.getClassLoader());
        user = in.readParcelable(FirebaseUser.class.getClassLoader());
    }

    public Article() {
    }

    public static final Creator<Article> CREATOR = new Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(nom);
        parcel.writeString(description);
        parcel.writeParcelable(date, i);
        parcel.writeParcelable(user, i);
    }
}
