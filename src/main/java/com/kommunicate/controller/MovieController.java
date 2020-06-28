package com.kommunicate.controller;

import com.kommunicate.dto.ResponseDTO;
import com.kommunicate.model.Movies;
import com.kommunicate.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
@Slf4j
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping
    public ResponseEntity<ResponseDTO> getOptimalMovies(@RequestBody Movies movies) {
        log.info("into controller  method");
        ResponseDTO response = movieService.getOptimalMovies(movies);
        if (response != null)
            return new ResponseEntity<>(response, HttpStatus.OK);
        else
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}