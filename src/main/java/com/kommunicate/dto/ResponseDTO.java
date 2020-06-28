package com.kommunicate.dto;

import com.kommunicate.model.Movie;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
public class ResponseDTO {
    private long amount;
    private List<Movie> movies;
}
