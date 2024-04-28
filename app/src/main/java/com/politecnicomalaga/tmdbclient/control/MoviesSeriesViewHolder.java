package com.politecnicomalaga.tmdbclient.control;

import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.politecnicomalaga.tmdbclient.R;

public class MoviesSeriesViewHolder extends RecyclerView.ViewHolder {

    private TextView title;
    private TextView subtitle;
    private TextView text;
    private WebView image;
    public MoviesSeriesViewHolder(@NonNull View itemView, MoviesSeriesRVAdapter adapter) {
        super(itemView);

        title = (TextView) itemView.findViewById(R.id.tvTitle);
        subtitle = (TextView) itemView.findViewById(R.id.tvSubtitle);
        text = (TextView) itemView.findViewById(R.id.tvMovieText);
        image = (WebView) itemView.findViewById(R.id.wv_imageView);

    }

    public TextView getTitle() {
        return title;
    }

    public TextView getSubtitle() {
        return subtitle;
    }

    public TextView getText() {
        return text;
    }

    public WebView getImage() {
        return image;
    }
}
