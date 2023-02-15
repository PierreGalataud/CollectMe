package com.example.collectme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.collectme.Adapter.ArticleAdapter;
import com.example.collectme.DAO.ArticleDAO;
import com.example.collectme.DAO.CategoryDAO;
import com.example.collectme.Entity.Article;
import com.example.collectme.Entity.Category;

import org.checkerframework.checker.units.qual.C;

import java.util.ArrayList;

public class ArticleActivity extends AppCompatActivity {

    private Spinner sp_listArticle;
    private RecyclerView rv_listArticle;
    private ArticleAdapter articleAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        init();
        getAllCategorie();
        // getAllArticle();

    }

    public void init(){
        sp_listArticle = findViewById(R.id.sp_listearticle);
        rv_listArticle = findViewById(R.id.rv_listArticle);
    }
    public void getAllArticle(ArrayList<Category> listCategorie){
        ArticleDAO ad = new ArticleDAO();
        ad.getAllArticle(this,listCategorie);
    }

    public void getAllCategorie(){
        CategoryDAO cd = new CategoryDAO();
        cd.getAllCategorie(this);
    }
    public void getAllArticleComplete(ArrayList<Article> listArticle){
       fillRecyclerView(listArticle);
    }

    public void getAllCategorieComplete(ArrayList<Category> listCategorie){
        fillSpinner(listCategorie);
        getAllArticle(listCategorie);
    }

    public void fillSpinner(ArrayList<Category> listCategorie){
        ArrayList<String> listCategorieNom = new ArrayList<>();
        for(Category uneCategorie:listCategorie){
            Log.d("listCategorie", uneCategorie.toString());
            listCategorieNom.add(uneCategorie.getNom());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, listCategorieNom);
        sp_listArticle.setAdapter(adapter);
    }

    public void fillRecyclerView(ArrayList<Article> listArticle){
        articleAdapter = new ArticleAdapter(listArticle);
        layoutManager = new LinearLayoutManager(this);
        rv_listArticle.setLayoutManager(layoutManager);
        rv_listArticle.setAdapter(articleAdapter);

        articleAdapter.setOnClickLigneArticle(new ArticleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Article articleClicked = listArticle.get(position);
                Log.d("afficheArticle", articleClicked.toString());
                Toast.makeText(ArticleActivity.this, articleClicked.toString(), Toast.LENGTH_SHORT).show();
                Intent detailArticleIntent = new Intent(ArticleActivity.this, DetailArticleActivity.class);
                detailArticleIntent.putExtra("article", articleClicked);
                startActivity(detailArticleIntent);
            }
        });
    }


}