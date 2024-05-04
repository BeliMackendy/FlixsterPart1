package com.myApp.flixster.adapters;


import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.target.Target;
import com.myApp.flixster.GlideApp;
import com.myApp.flixster.R;
import com.myApp.flixster.models.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Movie> movies;

    public MovieAdapter(List<Movie> movies) {
        this.movies = movies;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder=null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        if (viewType == 0) {
            View view1 = inflater.inflate(R.layout.item_movie, parent, false);
            viewHolder = new ViewHolder1(view1);
        }
        if(viewType==1) {
            View view2 = inflater.inflate(R.layout.item_movie_populate, parent, false);
            viewHolder = new ViewHolder2(view2);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Movie movie = movies.get(position);

        if(holder.getItemViewType()==0)
        {
            ViewHolder1 v = (ViewHolder1) holder;
            v.bind_movie(movie);
        }
        if (holder.getItemViewType()==1)
        {
            ViewHolder2 v = (ViewHolder2) holder;
            v.bind_movie(movie);
        }
//        holder.tv_title.setText(movie.getTitle());
//        holder.tv_overview.setText(movie.getOverview());
//
//        String image = null;
//        int orientation = holder.mView.getResources().getConfiguration().orientation;
//        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
//            image = movie.getPosterPath();
//        } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            image = movie.getBackdropPath();
//        }
//
//        GlideApp.with(holder.mView.getContext())
//                .load(image)
//                .override(Target.SIZE_ORIGINAL)
//                .placeholder(R.drawable.movie)
//                .transform(new RoundedCorners(30))
//                .transition(DrawableTransitionOptions.withCrossFade(5000))
//                .into(holder.iv_movie);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (movies.get(position).getVote_average() > 5)
            return 1;
        else
            return 0;
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {
        public View mView;
        public TextView tv_title;
        public TextView tv_overview;
        public ImageView iv_movie;

        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            tv_title = mView.findViewById(R.id.tv_title);
            tv_overview = mView.findViewById(R.id.tv_overview);
            iv_movie = mView.findViewById(R.id.iv_movie);
        }

        public void bind_movie(Movie movie) {
            tv_title.setText(movie.getTitle());
            tv_overview.setText(movie.getOverview());

            String image = null;
            int orientation = mView.getResources().getConfiguration().orientation;
            if (orientation == Configuration.ORIENTATION_PORTRAIT) {
                image = movie.getPosterPath();
            } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                image = movie.getBackdropPath();
            }

            GlideApp.with(mView.getContext())
                    .load(image)
                    .override(400)
                    .placeholder(R.drawable.movie)
                    .transform(new RoundedCorners(30))
                    .transition(DrawableTransitionOptions.withCrossFade(5000))
                    .into(iv_movie);
        }
    }

    public class ViewHolder2 extends RecyclerView.ViewHolder {

        public View mView;
        public ImageView iv_movie_populate;

        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            iv_movie_populate = mView.findViewById(R.id.iv_movie_populate);
        }

        public void bind_movie(Movie movie) {
            String image = null;
            int orientation = mView.getResources().getConfiguration().orientation;
            if (orientation == Configuration.ORIENTATION_PORTRAIT) {
                image = movie.getPosterPath();
            } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                image = movie.getBackdropPath();
            }

            GlideApp.with(mView.getContext())
                    .load(image)
                    .override(400)
                    .placeholder(R.drawable.movie)
                    .transform(new RoundedCorners(30))
                    .transition(DrawableTransitionOptions.withCrossFade(5000))
                    .into(iv_movie_populate);
        }
    }
}
