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

// adapter to build streaming service view
public class StreamingAdapter extends ArrayAdapter<StreamingData> {
    public StreamingAdapter(@NonNull Context context, ArrayList<StreamingData> dataArrayList) {
        super(context, R.layout.activity_custom_list_view, dataArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        StreamingData streamingData = getItem(position);

        if(view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.activity_streaming_list_view, parent, false);
        }

        ImageView streamingImage = view.findViewById(R.id.streaming_pic);
        TextView streamingTitle = view.findViewById(R.id.streaming_title);

        streamingImage.setImageResource(streamingData.streamingImage);
        streamingTitle.setText(streamingData.streamingTitle);

        return view;
    }
}
