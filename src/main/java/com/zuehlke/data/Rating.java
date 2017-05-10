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
}
