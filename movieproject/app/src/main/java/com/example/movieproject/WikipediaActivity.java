package com.example.movieproject;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

// display wikipedia webpage in app
public class WikipediaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wikipedia);

        WebView wikiViewWeb = findViewById(R.id.wikipediaView);
        wikiViewWeb.getSettings().setJavaScriptEnabled(true);

        String[] wikipediaLinks = getResources().getStringArray(R.array.wikiLinks);
        int position = getIntent().getIntExtra("position", 0);
        String selectedLink = wikipediaLinks[position];

        wikiViewWeb.loadUrl(selectedLink);
        wikiViewWeb.setWebViewClient(new WebViewClient());
    }
}
