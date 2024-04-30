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
            loadData("movies");
        }
        return listaResultados;
    }

    public void loadData(String search) {
        // Do an asynchronous operation to fetch data.
        myRequest = new RequestClient(this);
        myRequest.getDataFromRESTAPI(search);
        this.setData();
    }

    public void setData() {
        listaResultados.postValue(myRequest.getListData());
    }

}
