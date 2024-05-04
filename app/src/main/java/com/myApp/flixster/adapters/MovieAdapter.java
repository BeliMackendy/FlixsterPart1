package com.myApp.flixster.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.target.Target;
import com.myApp.flixster.GlideApp;
import com.myApp.flixster.R;
import com.myApp.flixster.models.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private List<Movie> movies;

    public MovieAdapter(List<Movie> movies) {
        this.movies = movies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Movie movie = movies.get(position);

            holder.tv_title.setText(movie.getTitle());
            holder.tv_overview.setText(movie.getOverview());

        int radius = 30; // corner radius, higher value = more rounded

        GlideApp.with(holder.mView.getContext())
                .load(movie.getPosterPath())
                .into(holder.iv_movie);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public View mView;
        public TextView tv_title;
        public  TextView tv_overview;
        public ImageView iv_movie;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mView= itemView;
            tv_title= mView.findViewById(R.id.tv_title);
            tv_overview = mView.findViewById(R.id.tv_overview);
            iv_movie = mView.findViewById(R.id.iv_movie);
        }
    }
}
