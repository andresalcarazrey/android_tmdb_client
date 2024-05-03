package com.politecnicomalaga.tmdbclient.control;

import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.politecnicomalaga.tmdbclient.R;

/**
 * Una clase RecyclerView.ViewHolder (simplificando, ViewHolder) es una clase que se encarga
 * de "meter" datos de un objeto de datos del ViewModel en los textview, editText, Webview, etc que tengamos
 * en una row del RecyclerView
 * Si la fila del RV tiene, por ejemplo, 4 views, tres textos y una imagen, como en este caso, tendremos 3 TextView
 * y un WebView como atributos.
 */
public class MoviesSeriesViewHolder extends RecyclerView.ViewHolder {

    private TextView title;
    private TextView subtitle;
    private TextView text;
    private WebView image;  //Si las imágenes están en la nube (internet), mejor un webview, no usar ImageView
    public MoviesSeriesViewHolder(@NonNull View itemView, MoviesSeriesRVAdapter adapter) {
        super(itemView);

        //El constructor lo que hace es "buscar" los elementos "views" que se necesiten para cada row
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
