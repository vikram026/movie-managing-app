package com.kommunicate.controller;

import com.kommunicate.dto.ResponseDTO;
import com.kommunicate.model.Movie;
import com.kommunicate.model.Movies;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MovieControllerComponentTest {

    @Autowired
    private MovieController movieController;

    @DisplayName("This method will test the getOptimalMovies method ")
    @ParameterizedTest
    @MethodSource("getMoviesSource")
    public void getOptimalMoviesTest(Movies movies) {
        ResponseEntity<ResponseDTO> responseEntity = movieController.getOptimalMovies(movies);
        assertAll("savetest",
                () -> assertEquals(responseEntity.getStatusCode(), HttpStatus.OK, () -> "status should be 200")
                , () -> assertEquals(responseEntity.getBody().getMovies().get(0).getName(), "Drive", () -> "name should be mocked data movie name")
        );
    }
    private static Stream<Arguments> getMoviesSource(){
        return Stream.of(Arguments.of(mockMovies()));
    }

    private static Movies mockMovies() {
        Movies movies=new Movies();
        Movie movie=new Movie();
        movie.setName("Drive");
        movie.setStartDate(new Date());
        movie.setEndDate(new Date());
        movies.setMovieList(Arrays.asList(movie));
        return movies;
    }
}