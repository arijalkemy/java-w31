package com.example.qatest.model.dto;

import java.time.LocalDate;

public class TestDTO {
    Long id;
    String description;
    Boolean tested;
    Boolean passed;
    int number_of_tries;
    LocalDate last_update;
}
