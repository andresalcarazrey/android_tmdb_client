package com.politecnicomalaga.tmdbclient.model;

/**
 * Esta clase encapsula TODO un JSON completo devuelto desde TMDB ante una petición
 * Es una clase muy simple a imagen y semejanza de su json para usarla con GSON
 */
public class MovieResultSet {
    private int page;
    private MovieSerieItem[] results;
    private int total_pages;
    private int total_results;

    public MovieResultSet() {

    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public MovieSerieItem[] getResults() {
        return results;
    }

    public void setResults(MovieSerieItem[] results) {
        this.results = results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }
}
