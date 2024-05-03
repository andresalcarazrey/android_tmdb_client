package com.politecnicomalaga.tmdbclient.model;

/**
 * Clase para encapsular los datos de una peli o serie
 * Está diseñada siguiendo las indicaciones del JSON que nos da TMDB para cada peli o serie
 */
public class MovieSerieItem {


    //JSON Movie Item: Ejemplo del JSON que representa a UNA peli
    /*
        "adult":false,
    "backdrop_path":"/kXfqcdQKsToO0OUXHcrrNCHDBzO.jpg",
    "genre_ids":[
        18,
        80
    ],
    "id":278,
    "original_language":"en",
    "original_title":"The Shawshank Redemption",
    "overview":"Framed in the 1940s for the double murder of his wife and her lover, upstanding banker Andy Dufresne begins a new life at the Shawshank prison, where he puts his accounting skills to work for an amoral warden. During his long stretch in prison, Dufresne comes to be admired by the other inmates -- including an older prisoner named Red -- for his integrity and unquenchable sense of hope.",
    "popularity":130.545,
    "poster_path":"/9cqNxx0GxF0bflZmeSMuL5tnGzr.jpg",
    "release_date":"1994-09-23",
    "title":"The Shawshank Redemption",
    "video":false,
    "vote_average":8.704,
    "vote_count":26063
     */

    private boolean adult;
    private String backdrop_path;
    private int[] genre_ids;
    private int id;
    private String original_language;
    private String original_title;
    private String overview;
    private float popularity;
    private String poster_path;
    private String release_date;
    private boolean video;
    private float vote_average;
    private long vote_count;
    private String title;
    private String original_name;
    private String name;


    public MovieSerieItem() {
    }

    //Realmente no hay un atributo imageURL, pero YO SE que "http://image.tmdb.org/t/p/wSIZE + poster path
    //contendrá una imagen del ancho SIZE. Uno de los anchos disponibles es 500px. Hay más.
    public String getImageURL() {
        return "https://image.tmdb.org/t/p/w500" + poster_path;
    }

    //Aquí lo mismo que en los demás métodos, escogemos un getter más genérico y le damos el dato
    //que nos interese
    public String getTitle() {
        if (title == null || title.isEmpty()) return name;
        return title;
    }

    //Aquí volvemos a "cambiar" el nombre del método get para hacerlo más "amable" al uso en nuestra app
    //Así, si queremos cambiar que dato se ve como segundo dato, podemos elegir el que nos de la gana
    //aquí
    public String getSubtitle() {
        if (release_date == null || release_date.isEmpty()) {
            return "Popularity: " + popularity;
        } else
            return release_date;
    }

    public String getText() {
        return overview;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public int[] getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(int[] genre_ids) {
        this.genre_ids = genre_ids;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public float getPopularity() {
        return popularity;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public float getVote_average() {
        return vote_average;
    }

    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }

    public long getVote_count() {
        return vote_count;
    }

    public void setVote_count(long vote_count) {
        this.vote_count = vote_count;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginal_name() {
        return original_name;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
