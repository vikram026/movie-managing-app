package com.kommunicate.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
public class Movie {

    private String name;
    private Date startDate;
    private Date endDate;

}
