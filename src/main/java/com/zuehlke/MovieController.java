package com.zuehlke;

import com.zuehlke.data.Movie;
import com.zuehlke.data.MovieSummary;
import com.zuehlke.data.Rating;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class MovieController {

    @GetMapping("movies")
    public List<MovieSummary> getMovies() {
        return Arrays.asList(
                new MovieSummary(1, "Batman Begins", "https://images-na.ssl-images-amazon.com/images/M/MV5BNTM3OTc0MzM2OV5BMl5BanBnXkFtZTYwNzUwMTI3._V1_SX300.jpg"),
                new MovieSummary(2, "Ted", "https://images-na.ssl-images-amazon.com/images/M/MV5BMTQ1OTU0ODcxMV5BMl5BanBnXkFtZTcwOTMxNTUwOA@@._V1_SX300.jpg"),
                new MovieSummary(3, "Inception", "https://images-na.ssl-images-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_SX300.jpg")
        );
    }

    @GetMapping("movies/{id}")
    public Movie getMovie(@PathVariable("id") Integer id) {
        return new Movie(id, "title", "poster", "plot", 2014, "genre", Arrays.asList(new Rating("AlloCine", "18%")));
    }

}
