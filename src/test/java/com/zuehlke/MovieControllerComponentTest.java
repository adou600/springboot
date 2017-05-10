package com.zuehlke;

import com.zuehlke.data.Movie;
import com.zuehlke.data.MovieSummary;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MovieControllerComponentTest {

    @LocalServerPort
    private int port;

    @Before
    public void setUp() throws Exception {
        RestAssured.port = port;
    }

    @Test
    public void getMovies() throws Exception {
        when().
                get("/api/v1/movies").
                then().
                statusCode(200)
                .body(
                        "", hasSize(3),
                        "[0].id", equalTo(1),
                        "id", hasItems(2, 3, 1),
                        "title", hasItems("Inception", "Ted", "Batman Begins"));
    }

    @Test
    public void getMovieById() throws Exception {
        final int givenId = 1;

        //Attention: if movie is taken, changes in movie will be automatically updated and therefore interface changes will not pop up...
        Movie movie = when().get("/api/v1/movies/" + givenId).as(Movie.class);
        assertEquals("title", movie.getTitle());
        assertEquals("poster", movie.getPoster());
        assertEquals(givenId, movie.getId());


        Response response = when().
                get("/api/v1/movies/" + givenId).
                then().contentType(ContentType.JSON).body("id", equalTo(givenId)).
                extract().response();
    }

}