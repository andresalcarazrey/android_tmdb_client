package com.politecnicomalaga.tmdbclient.control;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.politecnicomalaga.tmdbclient.data.RequestClient;
import com.politecnicomalaga.tmdbclient.model.MovieSerieItem;

import java.util.List;

public class MoviesViewModel extends ViewModel {

    private MutableLiveData<List<MovieSerieItem>> listaResultados;
    private RequestClient myRequest;
    public LiveData<List<MovieSerieItem>> getResults() {
        if (listaResultados == null) {
            listaResultados = new MutableLiveData<List<MovieSerieItem>>();
            loadData();
        }
        return listaResultados;
    }

    private void loadData() {
        // Do an asynchronous operation to fetch data.
        myRequest = new RequestClient(this);
        myRequest.getDataFromRESTAPI("movies");
        this.setData();
    }

    public void setData() {
        listaResultados.postValue(myRequest.getListData());
    }

}
