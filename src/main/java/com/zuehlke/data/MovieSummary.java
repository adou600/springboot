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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieSummary that = (MovieSummary) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        return poster != null ? poster.equals(that.poster) : that.poster == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (poster != null ? poster.hashCode() : 0);
        return result;
    }
}
