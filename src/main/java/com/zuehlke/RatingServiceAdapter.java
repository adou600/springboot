package com.zuehlke;


import com.zuehlke.data.Rating;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

@Component
public class RatingServiceAdapter {

    private final RatingServiceApiClient ratingsApiClient;

    public RatingServiceAdapter(@Value("${endpoint.movie-rating-service}") String url) {
        ratingsApiClient = RestClientFactory.createClient(url, RatingServiceApiClient.class);
    }

    public List<Rating> getRatingsById(long id) {
        return ratingsApiClient.getRatings(id);
    }
}