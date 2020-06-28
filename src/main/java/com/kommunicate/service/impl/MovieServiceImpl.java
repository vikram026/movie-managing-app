package com.kommunicate.service.impl;

import com.kommunicate.dto.ResponseDTO;
import com.kommunicate.model.Movie;
import com.kommunicate.model.Movies;
import com.kommunicate.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

@Slf4j
@Service
public class MovieServiceImpl implements MovieService {

    List<Movie> optimalMovies;

    @Override
    public ResponseDTO getOptimalMovies(Movies movies) {

        log.debug("into MovieServiceImpl :: getOptimalMovies ");
        optimalMovies = new ArrayList<>();
        prepareListOfOptimalMovies(movies);
        ResponseDTO responseDTO = buildResponseDTO();
        log.info("RespnseDTO : {}", responseDTO.toString());
        return responseDTO;
    }

    private ResponseDTO buildResponseDTO() {
        log.debug("Into DTO Preparation ");
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setAmount(optimalMovies.size() * 10000000);
        responseDTO.setMovies(optimalMovies);
        return responseDTO;
    }

    private void prepareListOfOptimalMovies(Movies movies) {
        log.debug("Optimal Movie list Preparation");
        movies.getMovieList()
                .stream()
                .sorted(Comparator.comparing(Movie::getEndDate))
                .forEach(movieConsumer());
        log.debug("End of Optimal Movie list Preparation, prepared list : {} ", optimalMovies);
    }

    private Consumer<Movie> movieConsumer() {
        return e -> {
            if (optimalMovies.isEmpty()
                    || e.getStartDate().after(optimalMovies.get(optimalMovies.size() - 1).getEndDate())) {
                log.debug("Movie {} has no conflict, adding it to the list", e.getName());
                optimalMovies.add(e);
            }
        };
    }
}
