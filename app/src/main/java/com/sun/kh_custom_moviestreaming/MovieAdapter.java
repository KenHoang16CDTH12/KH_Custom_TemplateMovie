package com.sun.kh_custom_moviestreaming;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private List<Movie> mMovies;
    private MovieItemClickListener mListener;

    public MovieAdapter(List<Movie> movies) {
        mMovies = movies;
    }

    public void setListener(MovieItemClickListener listener) {
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(mMovies.get(position));
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        private ImageView mImage;
        private TextView mTitle;
        private MovieItemClickListener mListener;
        private Movie mMovie;

        private ViewHolder(@NonNull View itemView, MovieItemClickListener listener) {
            super(itemView);
            mImage = itemView.findViewById(R.id.image);
            mTitle = itemView.findViewById(R.id.title);
            mListener = listener;
            itemView.setOnClickListener(this);
        }

        private void bindData(Movie movie) {
            mMovie = movie;
            mImage.setImageResource(movie.getThumbnail());
            mTitle.setText(movie.getTitle());
        }

        @Override
        public void onClick(View view) {
            mListener.onMovieClick(mMovie, mImage);
        }
    }
}
