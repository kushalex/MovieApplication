package com.example.movieproject;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

// display streaming service webpage in app
public class StreamingWebpageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_streamingwebpage);

        String streamingWebpage = getIntent().getStringExtra("streamingWebpage");

        WebView streamingwebView = findViewById(R.id.streamingwebView);
        streamingwebView.getSettings().setJavaScriptEnabled(true);
        streamingwebView.setWebViewClient(new WebViewClient());
        streamingwebView.loadUrl(streamingWebpage);
    }
}
