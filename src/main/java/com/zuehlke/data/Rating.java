package com.zuehlke.data;

/**
 * Created by adni on 10.05.17.
 */
public class Rating {
    private String source;
    private String value;

    public Rating() {
    }

    public Rating(String source, String value) {
        this.source = source;
        this.value = value;
    }

    public String getSource() {
        return source;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rating rating = (Rating) o;

        if (source != null ? !source.equals(rating.source) : rating.source != null) return false;
        return value != null ? value.equals(rating.value) : rating.value == null;
    }

    @Override
    public int hashCode() {
        int result = source != null ? source.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
