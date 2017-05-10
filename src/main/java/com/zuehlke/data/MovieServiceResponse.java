package com.zuehlke.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by adni on 10.05.17.
 */
public class MovieServiceResponse {

    private int id;
    private String title;
    private String poster;
    private String plot;
    private int year;
    private String genre;

    @JsonCreator
    public MovieServiceResponse(@JsonProperty("id") int id,
                                @JsonProperty("title") String title,
                                @JsonProperty("poster") String poster,
                                @JsonProperty("plot") String plot,
                                @JsonProperty("year") int year,
                                @JsonProperty("genre") String genre) {
        this.id = id;
        this.title = title;
        this.poster = poster;
        this.plot = plot;
        this.year = year;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPoster() {
        return poster;
    }

    public String getPlot() {
        return plot;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }


}
