package com.zuehlke.data;

import java.util.List;

/**
 * Created by adni on 10.05.17.
 */
public class MovieSummary {

    private int id;
    private String title;
    private String poster;


    public MovieSummary() {
    }

    public MovieSummary(int id, String title, String poster) {
        this.id = id;
        this.title = title;
        this.poster = poster;
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

}
