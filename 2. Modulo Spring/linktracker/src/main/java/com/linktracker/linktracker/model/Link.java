package com.linktracker.linktracker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Link {
    private Integer id;
    private String url;
    private String password;
    private Boolean valid;
    private Integer redirectCount;

}
