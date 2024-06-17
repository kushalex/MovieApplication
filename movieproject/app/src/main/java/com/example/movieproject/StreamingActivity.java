package com.example.movieproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.movieproject.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class StreamingActivity extends AppCompatActivity {

    ArrayList<StreamingData> dataArrayList = new ArrayList<>();

    StreamingData streamingData;
    StreamingAdapter streamingAdapter;

    // build listview containing streaming services elements

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_streaming);

        ListView streamingListView = findViewById(R.id.streamingView);

        int[] streamingImageList = {R.drawable.prime, R.drawable.youtube, R.drawable.appletv};
        int[] streamingTitleList = {R.string.streaming1title, R.string.streaming2title, R.string.streaming3title};

        for(int i = 0; i < streamingImageList.length; i++) {
            streamingData = new StreamingData(streamingTitleList[i], streamingImageList[i]);
            dataArrayList.add(streamingData);
        }

        streamingAdapter = new StreamingAdapter(StreamingActivity.this, dataArrayList);
        streamingListView.setAdapter(streamingAdapter);
        streamingListView.setClickable(true);

        // on click open streaming service movie webpage
        streamingListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                // check what streaming service was selected, and update webpage links with that service

                String selectedStreamingTitle = getResources().getString(streamingTitleList[i]);
                String[] streamingWebpage;

                // amazon service -> use amazon webpage links

                if (selectedStreamingTitle.equals(getString(R.string.streaming1title))) {
                    streamingWebpage = getResources().getStringArray(R.array.streamingWebpage1);
                    int position = getIntent().getIntExtra("position", 0);
                    String selectedStreamingWebpage = streamingWebpage[position];
                    Intent intent = new Intent(StreamingActivity.this, StreamingWebpageActivity.class);
                    intent.putExtra("streamingWebpage", selectedStreamingWebpage);
                    startActivity(intent);
                }

                // youtube service -> use youtube webpage links

                else if (selectedStreamingTitle.equals(getString(R.string.streaming2title))) {
                    streamingWebpage = getResources().getStringArray(R.array.streamingWebpage2);
                    int position = getIntent().getIntExtra("position", 0);
                    String selectedStreamingWebpage = streamingWebpage[position];
                    Intent intent = new Intent(StreamingActivity.this, StreamingWebpageActivity.class);
                    intent.putExtra("streamingWebpage", selectedStreamingWebpage);
                    startActivity(intent);
                }

                // apple tv service -> use apple tv webpage links

                else if (selectedStreamingTitle.equals(getString(R.string.streaming3title))) {
                    streamingWebpage = getResources().getStringArray(R.array.streamingWebpage3);
                    int position = getIntent().getIntExtra("position", 0);
                    String selectedStreamingWebpage = streamingWebpage[position];
                    Intent intent = new Intent(StreamingActivity.this, StreamingWebpageActivity.class);
                    intent.putExtra("streamingWebpage", selectedStreamingWebpage);
                    startActivity(intent);
                }
            }
        });
    }
}
