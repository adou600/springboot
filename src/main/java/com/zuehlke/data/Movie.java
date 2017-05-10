package com.zuehlke.data;

import java.util.List;

/**
 * Created by adni on 10.05.17.
 */
public class Movie {

    private int id;
    private String title;
    private String poster;
    private String plot;
    private int year;
    private String genre;
    private List<Rating> ratings;


    public Movie() {
    }

    public Movie(int id, String title, String poster, String plot, int year, String genre, List<Rating> ratings) {
        this.id = id;
        this.title = title;
        this.poster = poster;
        this.plot = plot;
        this.year = year;
        this.genre = genre;
        this.ratings = ratings;
    }

    public static MovieSummary from(MovieServiceResponse response) {
        return new MovieSummary(response.getId(), response.getTitle(), response.getPoster());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public Movie setRatings(List<Rating> ratings) {
        this.ratings = ratings;
        return this;
    }

}
