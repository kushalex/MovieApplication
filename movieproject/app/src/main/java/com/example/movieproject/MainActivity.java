package com.example.movieproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.movieproject.databinding.ActivityMainBinding;
import com.example.movieproject.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    MovieAdapter movieAdapter;
    ArrayList<MovieData> dataArrayList = new ArrayList<>();
    MovieData movieData;

    // build listview containing movie elements
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        registerForContextMenu(binding.listView);

        int[] movieImageList = {R.drawable.movie1min, R.drawable.movie2min, R.drawable.movie3min,
                                R.drawable.movie4min, R.drawable.movie5min, R.drawable.movie6min,
                                R.drawable.movie7min, R.drawable.movie8min};

        int[] movieTitleList = {R.string.movie1title, R.string.movie2title, R.string.movie3title,
                                R.string.movie4title, R.string.movie5title, R.string.movie6title,
                                R.string.movie7title, R.string.movie8title};

        int[] movieActorsList = {R.string.movie1actors, R.string.movie2actors, R.string.movie3actors,
                                 R.string.movie4actors, R.string.movie5actors, R.string.movie6actors,
                                 R.string.movie7actors, R.string.movie8actors};

        for(int i = 0; i < movieImageList.length; i++) {
            movieData = new MovieData(movieTitleList[i], movieActorsList[i], movieImageList[i]);
            dataArrayList.add(movieData);
        }

        movieAdapter = new MovieAdapter(MainActivity.this, dataArrayList);
        binding.listView.setAdapter(movieAdapter);
        binding.listView.setClickable(true);

        // on click opens official movie webpage
        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String[] movieWebpage = getResources().getStringArray(R.array.movieWebpage);
                String selectedMovieWebpage = movieWebpage[i];
                Intent intent = new Intent(MainActivity.this, MovieWebpageActivity.class);
                intent.putExtra("movieWebpage", selectedMovieWebpage);
                startActivity(intent);
            }
        });
    }

    // context menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    // three options for the context menu
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int position = info.position;

        int[] movieImageListHD = {R.drawable.movie1, R.drawable.movie2, R.drawable.movie3,
                R.drawable.movie4, R.drawable.movie5, R.drawable.movie6,
                R.drawable.movie7, R.drawable.movie8};

        int posterResource = movieImageListHD[position];

        // full poster context menu option
        if (item.getItemId() == R.id.fullPoster) {
            Intent intent = new Intent(MainActivity.this, FullPosterActivity.class);
            intent.putExtra("posterDrawable", posterResource);
            intent.putExtra("position", position);
            startActivity(intent);
            return true;
        }

        // wikipedia webpage context menu option
        String[] wikipediaLinks = getResources().getStringArray(R.array.wikiLinks);
        String wikipediaResource = wikipediaLinks[position];

        if(item.getItemId() == R.id.wikipediaPage) {
            Intent intent = new Intent(MainActivity.this, WikipediaActivity.class);
            intent.putExtra("wikipediaLink", wikipediaResource);
            intent.putExtra("position", position);
            startActivity(intent);
            return true;
        }

        // streaming services context menu option
        if(item.getItemId() == R.id.streamingServices) {
            Intent intent = new Intent(MainActivity.this, StreamingActivity.class);
            intent.putExtra("position", position);
            startActivity(intent);
            return true;
        }
        else {
            return super.onContextItemSelected(item);
        }
    }
}