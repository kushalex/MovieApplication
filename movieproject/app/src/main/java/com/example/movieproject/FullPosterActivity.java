package com.example.movieproject;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

// new activity to show full screened movie poster
public class FullPosterActivity extends AppCompatActivity {

    // display poster
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullposter);

        int posterDrawable = getIntent().getIntExtra("posterDrawable", 0);

        ImageView imageView = findViewById(R.id.posterView);
        imageView.setImageResource(posterDrawable);

        // open movie webpage when poster short clicked
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_posterclick);

                WebView posterViewWeb = findViewById(R.id.posterViewWeb);
                posterViewWeb.getSettings().setJavaScriptEnabled(true);

                String[] posterWebpages = getResources().getStringArray(R.array.movieWebpage);
                int position = getIntent().getIntExtra("position", 0);
                String selectedPoster = posterWebpages[position];

                posterViewWeb.loadUrl(selectedPoster);

                posterViewWeb.setWebViewClient(new WebViewClient());
            }
        });
    }
}
