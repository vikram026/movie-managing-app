package com.kommunicate.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Movies {
    List<Movie> movieList;
}
