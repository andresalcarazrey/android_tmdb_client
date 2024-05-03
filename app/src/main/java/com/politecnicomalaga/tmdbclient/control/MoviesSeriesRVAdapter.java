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

/**
 * La clase RecyclerView.Adapter<Viewholder> se encarga de contener una copia de la lista de datos de nuestro viewmodel
 * Se encarga, por lo tanto de coger datos (lista normalmente) del viewmodel a través del constructor (en el fondo es una
 * referencia), y después de obtener los "holders" que se necesiten para rellenar el espacio del RV (método onCreateViewHolder,
 * es un override, es de Android)
 * En el método onBindViewHolder enganchamos el contenido de un objeto de la lista con los views del holder que los van a mostrar
 * Por último getItemCount da el tamaño del modelo en concreto para que el RV sepa cuando parar el scrolling
 */
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

        //El comando anterior usa el rv_main_item que está en forma de fichero XML dentro de res/layouts
        //para saber "cómo pintar los componentes" de cada fila del RV

        return new MoviesSeriesViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesSeriesViewHolder holder, int position) {
        //TODO: fill data
        //Lo primero, ver que indice de la lista se quiere pasar a la pantalla, eso el argumento position
        //RECORDAD, estos métodos los usa el propio sistema ANDRIOD. Están "prefabricados" a falta de que vosotros
        //lo reutilicéis
        MovieSerieItem msi = this.dataList.get(position);


        //TRUCO para mostrar imágenes con zoom dentro de un recuadro para webs. Se encapsula la imagen en HTML
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
