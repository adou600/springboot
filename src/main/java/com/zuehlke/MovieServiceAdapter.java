package com.zuehlke;

import com.zuehlke.data.Movie;
import com.zuehlke.data.MovieServiceResponse;
import com.zuehlke.data.MovieSummary;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;


public class MovieServiceAdapter {

    private final MovieServiceApiClient moviesApiClient;

    public MovieServiceAdapter(String url) {
        moviesApiClient = RestClientFactory.createClient(url, MovieServiceApiClient.class);
    }

    public List<MovieSummary> getAll() {
        List<MovieServiceResponse> moviesResponse = moviesApiClient.getMovies();

        return moviesResponse.stream()
                .map(Movie::from)
                .collect(toList());
    }

    public Optional<Movie> getMovieById(int id) {
        MovieServiceResponse response = moviesApiClient.getMovieById(id);
        return Optional.of(new Movie(response.getId(), response.getTitle(), response.getPoster(), response.getPlot(), response.getYear(), response.getGenre(), null));
    }
}

