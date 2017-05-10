package com.zuehlke;

import com.zuehlke.data.Movie;
import com.zuehlke.data.MovieServiceResponse;
import com.zuehlke.data.MovieSummary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Component
public class MovieServiceAdapter implements HealthIndicator {

    private final MovieServiceApiClient moviesApiClient;

    public MovieServiceAdapter(@Value("${endpoint.movie-service}") String url) {
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

    @Override
    public Health health() {
        moviesApiClient.getHealth();
        return Health.up().build();
    }
}

