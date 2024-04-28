package com.politecnicomalaga.tmdbclient.data;

import com.google.gson.Gson;
import com.politecnicomalaga.tmdbclient.control.MoviesViewModel;
import com.politecnicomalaga.tmdbclient.model.MovieSerieItem;

import java.util.ArrayList;
import java.util.List;

//Clase para realizar la petición y recibir la respuesta desde Internet de la API Rest
public class RequestClient {

    //IMAGES:
/*
https://image.tmdb.org/t/p/w500/h4FuqnkBrZ6Wxi4TEeB99QvL590.jpg
        *
        * */

    private static final String URL = "https://api.themoviedb.org/3/search/movie?query=%query%&include_adult=false&language=en-US&page=1";
    private static final String URLAllMovies = "https://api.themoviedb.org/3/discover/movie?include_adult=false&include_video=false&language=en-US&page=1&sort_by=vote_average.desc&without_genres=99,10755&vote_count.gte=200";
    private static final String URLAllSeries = "https://api.themoviedb.org/3/discover/tv?include_adult=false&language=en-US&page=1&sort_by=vote_average.desc&vote_count.gte=200";


    //Atributos
    private boolean error;
    private List<MovieSerieItem> listData;
    private MoviesViewModel vmInstance;

    //Métodos

    public RequestClient(MoviesViewModel vmInstance) {
        error = false;
        this.vmInstance = vmInstance;
        listData = new ArrayList<>();
    }
    public void getDataFromRESTAPI(String query) {
        DataMovieAccess myDMA = new DataMovieAccess(this);
        error = false;
        String queryURL;
        if (query.equals("movies")) {
            queryURL = URLAllMovies;
        } else if (query.equals("series")) {
            queryURL = URLAllSeries;
        } else
            queryURL = URL.replace("%query%",query);

        myDMA.requestData(queryURL);
    }

    public void setDataFromRESTAPI(String json) {
        //Procesar el JSON para pasarlo a objetos del modelo, una lista de películas o series
        Gson gson = new Gson();
        // gson.fromJson(json, MovieSerieItem[].class);

        //TEST
        listData.clear();
        listData.add(new MovieSerieItem("https://image.tmdb.org/t/p/w500/h4FuqnkBrZ6Wxi4TEeB99QvL590.jpg","The Goonies","Family/Adventures","This movie from the 80's was an iconic adventure movie for kids and teenagers"));
        listData.add(new MovieSerieItem("https://image.tmdb.org/t/p/w500/h4FuqnkBrZ6Wxi4TEeB99QvL590.jpg","The Goonies","Family/Adventures","This movie from the 80's was an iconic adventure movie for kids and teenagers"));
        this.vmInstance.setData();
    }

    public void activateError() {
        error = true;
    }

    public boolean isError() {
        return error;
    }

    public List<MovieSerieItem> getListData() {
        return listData;
    }
}

