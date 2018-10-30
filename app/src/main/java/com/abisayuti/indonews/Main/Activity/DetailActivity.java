package com.abisayuti.indonews.Main.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.abisayuti.indonews.R;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.imgMain)
    ImageView imgMain;
    @BindView(R.id.titleMain)
    TextView titleMain;
    @BindView(R.id.publisherMain)
    TextView publisherMain;
    @BindView(R.id.deskripsiMain)
    TextView deskripsiMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        String detailTitle = getIntent().getStringExtra("title");
        String detailPublishd = getIntent().getStringExtra("publish");
        String detailContent = getIntent().getStringExtra("content");
        String detailGambar = getIntent().getStringExtra("gambar");

        titleMain.setText(detailTitle);
        publisherMain.setText(detailPublishd);
        deskripsiMain.setText(detailContent);

        Glide.with(this)
                .load(detailGambar)
                .into(imgMain);


    }
}
