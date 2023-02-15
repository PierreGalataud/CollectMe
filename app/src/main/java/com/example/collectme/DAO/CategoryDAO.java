package com.example.collectme.DAO;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.collectme.ArticleActivity;
import com.example.collectme.Entity.Category;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    FirebaseFirestore db;
    FirebaseUser user;
    public CategoryDAO() {
        this.db = FirebaseFirestore.getInstance();
    }

 public void getAllCategorie(Context context){
        db.collection("Categorie").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    ArrayList<Category> listCategorie = new ArrayList<>();
                    List<DocumentSnapshot> result = task.getResult().getDocuments();
                    for (DocumentSnapshot document : result) {
                        Category uneCategorie = new Category();
                        uneCategorie.setId(document.getId());
                        uneCategorie.setNom(document.get("nom").toString());

                        listCategorie.add(uneCategorie);
                    }
                    ((ArticleActivity) context).getAllCategorieComplete(listCategorie);
                } else {
                    Log.w("selectall", "Error doc missing", task.getException());
                }
            }

        });
    }
 }


