package com.zuehlke;


import com.zuehlke.data.Rating;
import org.springframework.stereotype.Controller;

import java.util.List;


public class RatingServiceAdapter {

    private final RatingServiceApiClient ratingsApiClient;

    public RatingServiceAdapter(String url) {
        ratingsApiClient = RestClientFactory.createClient(url, RatingServiceApiClient.class);
    }

    public List<Rating> getRatingsById(long id) {
        return ratingsApiClient.getRatings(id);
    }
}