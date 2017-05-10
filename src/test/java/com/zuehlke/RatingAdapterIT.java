package com.zuehlke;

import com.zuehlke.data.Rating;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

// IntegrationTest
public class RatingAdapterIT {

    static {
        System.setProperty("hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds", "5000");
    }

    @Test
    public void getRatingsById() throws Exception {
        RatingServiceAdapter ratingServiceAdapter = new RatingServiceAdapter("https://movie-rating-service.herokuapp.com");

        List<Rating> ratings = ratingServiceAdapter.getRatingsById(1);

        assertThat(ratings, hasSize(3));
        assertThat(ratings, hasItem(new Rating("Internet Movie Database", "8.3/10")));
    }



}