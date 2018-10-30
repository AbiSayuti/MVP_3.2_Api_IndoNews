package com.abisayuti.indonews.Main.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.abisayuti.indonews.Main.Activity.DetailActivity;
import com.abisayuti.indonews.Main.Activity.MainActivity;
import com.abisayuti.indonews.Main.Model.ArticlesItem;
import com.abisayuti.indonews.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder>{
    Context context;
    List<ArticlesItem> articlesItems;

    public MainAdapter(MainActivity context, List<ArticlesItem> data) {
        this.context = context;
        this.articlesItems = data;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.list, viewGroup, false);
        return new MainViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder mainViewHolder, final int i) {
        ArticlesItem resep = articlesItems.get(i);
        mainViewHolder.NamaNews.setText(resep.getTitle());
        mainViewHolder.publisher.setText(resep.getAuthor());
        Glide.with(context)
                .load(articlesItems.get(i).getUrlToImage())
                .into(mainViewHolder.imgMain);

        mainViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("title", articlesItems.get(i).getTitle());
                intent.putExtra("publish", articlesItems.get(i).getPublishedAt());
                intent.putExtra("content", articlesItems.get(i).getContent());
                intent.putExtra("gambar", articlesItems.get(i).getUrlToImage());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articlesItems.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {
        TextView NamaNews, publisher;
        ImageView imgMain;
        public MainViewHolder(@NonNull View itemView) {
            super(itemView);

            imgMain = itemView.findViewById(R.id.imageNews);
            NamaNews = itemView.findViewById(R.id.TextTittle);
            publisher = itemView.findViewById(R.id.TextPublisher);
        }
    }
}
