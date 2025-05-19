package com.example.qatest.model.request;

import lombok.Data;

@Data
public class AddTestResultRequest {
    private Long testID;
    private boolean passed;
}