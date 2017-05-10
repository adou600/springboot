package com.zuehlke;

import com.zuehlke.data.Movie;
import com.zuehlke.data.MovieSummary;
import com.zuehlke.data.Rating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
public class MovieController {

    private final MovieServiceAdapter movieServiceAdapter;
    private final RatingServiceAdapter ratingServiceAdater;

    public MovieController(MovieServiceAdapter movieServiceAdapter, RatingServiceAdapter ratingServiceAdapter) {
        this.movieServiceAdapter = movieServiceAdapter;
        this.ratingServiceAdater = ratingServiceAdapter;
    }

    @GetMapping("movies")
    public List<MovieSummary> getMovies() {
        return movieServiceAdapter.getAll();
    }

    @GetMapping("movies/{id}")
    public Movie getMovie(@PathVariable("id") Integer id) {
        Optional<Movie> movieDetail = movieServiceAdapter.getMovieById(id);
        List<Rating> ratings = ratingServiceAdater.getRatingsById(id);

        return movieDetail.map(m -> m.setRatings(ratings))
                .orElseThrow(() -> new MovieNotFoundException("No movie found with id=" + id));
    }

}
