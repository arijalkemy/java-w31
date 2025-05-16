package com.example.qatest.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class NewTestRequest {
    String description;
    Boolean tested;
    Boolean passed;
    int number_of_tries;
    LocalDate last_update;
}
