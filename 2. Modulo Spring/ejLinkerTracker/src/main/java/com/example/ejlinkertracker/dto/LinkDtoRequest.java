package com.example.ejlinkertracker.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LinkDtoRequest {
    private Long id;
    private String url;
    private Integer numOfRedir;
    private Boolean isValid;
    private String password;
}
