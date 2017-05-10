package com.zuehlke;

import com.zuehlke.data.Rating;
import feign.Param;
import feign.RequestLine;

import java.util.List;

// MovieServiceApiClient Interface
public interface RatingServiceApiClient {

    @RequestLine("GET /api/v1/ratings/{id}")
    List<Rating> getRatings(@Param("id") long id);
}