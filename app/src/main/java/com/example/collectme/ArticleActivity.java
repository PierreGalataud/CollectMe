package com.example.collectme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.collectme.DAO.ArticleDAO;
import com.example.collectme.Entity.Article;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class ArticleActivity extends AppCompatActivity {

    private Spinner sp_listArticle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        init();
        getAllArticle();

    }

    public void init(){
        sp_listArticle = findViewById(R.id.sp_listearticle);
    }
    public void getAllArticle(){
        ArticleDAO ad = new ArticleDAO();
        ad.getAllProduit(this);
    }
    public void getAllArticleComplete(ArrayList<Article> listArticle){
       fillSpinner(listArticle);
    }
    public void fillSpinner(ArrayList<Article> listArticle){
        ArrayList<String> listArticleNom = new ArrayList<>();
        for(Article unArticle:listArticle){
            Log.d("listArticle", unArticle.toString());
            listArticleNom.add(unArticle.getNom());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, listArticleNom);
        sp_listArticle.setAdapter(adapter);
    }


}