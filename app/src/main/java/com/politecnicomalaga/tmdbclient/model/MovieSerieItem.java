package com.politecnicomalaga.tmdbclient.model;

public class MovieSerieItem {

    private String imageURL;
    private String title;
    private String subtitle;
    private String text;

    public MovieSerieItem(String imageURL, String title, String subtitle, String text) {
        this.imageURL = imageURL;
        this.title = title;
        this.subtitle = subtitle;
        this.text = text;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getText() {
        return text;
    }
}
