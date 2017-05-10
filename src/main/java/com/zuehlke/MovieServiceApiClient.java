package com.zuehlke;

import com.zuehlke.data.MovieServiceResponse;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface MovieServiceApiClient {
    @RequestLine("GET /api/v1/movies")
    List<MovieServiceResponse> getMovies();

    @RequestLine("GET /api/v1/movies/{id}")
    MovieServiceResponse getMovieById(@Param("id") long id);
}