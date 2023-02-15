package com.example.collectme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.collectme.Entity.Article;

public class DetailArticleActivity extends AppCompatActivity {

    private EditText et_nom, et_description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_article);
        init();

        Intent intent = getIntent();
        Article articleClick = intent.getParcelableExtra("article");
        et_nom.setText(articleClick.getNom());
        et_description.setText(articleClick.getDescription());
        Toast.makeText(this, articleClick.toString(),Toast.LENGTH_LONG).show();
    }

    public void init(){
        et_nom =  findViewById(R.id.et_detail_nom);
        et_description =  findViewById(R.id.et_detail_description);

    }
}