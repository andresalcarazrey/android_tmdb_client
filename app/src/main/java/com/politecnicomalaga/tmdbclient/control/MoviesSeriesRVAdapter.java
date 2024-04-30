package com.politecnicomalaga.tmdbclient.control;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.politecnicomalaga.tmdbclient.R;
import com.politecnicomalaga.tmdbclient.model.MovieSerieItem;

import java.util.List;

public class MoviesSeriesRVAdapter extends RecyclerView.Adapter<MoviesSeriesViewHolder> {


    private LayoutInflater mInflater;
    private List<MovieSerieItem> dataList;
    public MoviesSeriesRVAdapter(Context ct, List<MovieSerieItem> dataList) {
        this.dataList = dataList;
        mInflater = LayoutInflater.from(ct);
    }

    @NonNull
    @Override
    public MoviesSeriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.rv_main_item,
                parent, false);
        return new MoviesSeriesViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesSeriesViewHolder holder, int position) {
        //TODO: fill data
        MovieSerieItem msi = this.dataList.get(position);

        String html = "<html><body><img src=\"" + msi.getImageURL() + "\" width=\"100%\" height=\"100%\"\"/></body></html>";
        holder.getImage().loadData(html, "text/html", null);
        holder.getTitle().setText(msi.getTitle());
        holder.getSubtitle().setText(msi.getSubtitle());
        holder.getText().setText(msi.getText());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


}
