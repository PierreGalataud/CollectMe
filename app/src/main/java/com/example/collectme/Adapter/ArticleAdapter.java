package com.example.collectme.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collectme.Entity.Article;
import com.example.collectme.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {
    private ArrayList<Article> listArticle;
    private OnItemClickListener onClickLigneArticle;
    public ArticleAdapter(ArrayList<Article> listArticle) {
        this.listArticle = listArticle;
    }

    @NonNull
    @Override
    public ArticleAdapter.ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.ligne_article,parent,false);
        ArticleViewHolder articleViewHolder = new ArticleViewHolder(v,onClickLigneArticle);
        return articleViewHolder;
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnClickLigneArticle(OnItemClickListener listener){
        onClickLigneArticle = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleAdapter.ArticleViewHolder holder, int position) {
        Article articleEncours = listArticle.get(position);
        holder.tv_nomArticle.setText(articleEncours.getNom());
        holder.tv_descriptionArticle.setText(articleEncours.getDescription());

        // Assuming that you have a Firebase timestamp object called "timestamp"
        Date date = new Date(articleEncours.getDate().getSeconds() * 1000L); // Convert timestamp to Date object
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); // Define format of the string
        String formattedDate = sdf.format(date); // Convert date to string using format
        holder.tv_dateArticle.setText(formattedDate);
        holder.tv_categorieArticle.setText(articleEncours.getCategory().getNom());

    }

    @Override
    public int getItemCount() {
        return listArticle.size();
    }

    public class ArticleViewHolder extends RecyclerView.ViewHolder{
        public TextView tv_nomArticle;
        public TextView tv_descriptionArticle;
        public TextView tv_dateArticle;
        public TextView tv_categorieArticle;
        public TextView bt_detail;

        public ArticleViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            tv_nomArticle = itemView.findViewById(R.id.tv_nomArticle);
            tv_descriptionArticle = itemView.findViewById(R.id.tv_descriptionArticle);
            tv_dateArticle = itemView.findViewById(R.id.tv_dateArticle);
            tv_categorieArticle = itemView.findViewById(R.id.tv_categorieArticle);
            bt_detail = itemView.findViewById(R.id.bt_article_detail);
            bt_detail.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
