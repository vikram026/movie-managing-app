package com.kommunicate.service;

import com.kommunicate.dto.ResponseDTO;
import com.kommunicate.model.Movies;

public interface MovieService {
    ResponseDTO getOptimalMovies(Movies movies);
}
