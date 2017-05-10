package com.zuehlke;


import com.zuehlke.data.Rating;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class RatingServiceAdapter {

    private final RatingServiceApiClient ratingsApiClient;

    public RatingServiceAdapter(@Value("${endpoint.movie-rating-service}") String url) {

        RatingServiceApiClient fallback = (id) -> Collections.emptyList();
        ratingsApiClient = RestClientFactory.createClient(url, RatingServiceApiClient.class, fallback);
    }

    public List<Rating> getRatingsById(long id) {
        return ratingsApiClient.getRatings(id);
    }
}