package com.example.movieproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

// movie adapter and building view
public class MovieAdapter extends ArrayAdapter<MovieData> {

    public MovieAdapter(@NonNull Context context, ArrayList<MovieData> dataArrayList) {
        super(context, R.layout.activity_custom_list_view, dataArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        MovieData movieData = getItem(position);

        if(view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.activity_custom_list_view, parent, false);
        }

        ImageView movieImage = view.findViewById(R.id.movie_pic);
        TextView movieTitle = view.findViewById(R.id.movie_title);
        TextView movieActors = view.findViewById(R.id.movie_actors);

        movieImage.setImageResource(movieData.movieImage);
        movieTitle.setText(movieData.movieTitle);
        movieActors.setText(movieData.movieActors);

        return view;
    }
}
