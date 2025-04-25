package com.example.ejlinkertracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LinkTacker {
    private Long id;
    private String url;
    private Integer numOfRedir;
    private Boolean isValid;
    private String password;

}
