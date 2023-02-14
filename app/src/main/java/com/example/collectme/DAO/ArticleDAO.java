package com.example.collectme.DAO;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.collectme.ArticleActivity;
import com.example.collectme.Entity.Article;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ArticleDAO {
    FirebaseFirestore db;
    FirebaseUser user;
    public ArticleDAO() {
        this.db = FirebaseFirestore.getInstance();
        this.user = FirebaseAuth.getInstance().getCurrentUser();
    }

 public void getAllProduit(Context context){
        db.collection("Article").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    ArrayList<Article> listArticle = new ArrayList<Article>();
                    List<DocumentSnapshot> result = task.getResult().getDocuments();
                    for (DocumentSnapshot document : result) {
                        Article unArticle = new Article();
                        unArticle.setId(document.getId());
                        unArticle.setNom(document.get("nom").toString());
                        unArticle.setDescription(document.get("description").toString());
                        unArticle.setDate( Timestamp.class.cast(document.get("date")));
                        unArticle.setUser(user);
                        // finir user et catgorie

                        listArticle.add(unArticle);
                    }
                    ((ArticleActivity) context).getAllArticleComplete(listArticle);
                } else {
                    Log.w("selectall", "Error doc missing", task.getException());
                }
            }

        });
    }
 }


