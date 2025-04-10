package com.mercadolibre.linktracker.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class LinkTracker {
    private Integer id = 0;
    private String url;
    private String password;
    private Boolean valid;
    private Integer redirectionCount;

    public LinkTracker(String url, String password) {
        id++;
        this.password = password;
        this.url = url;
        valid = true;
        redirectionCount = 0;
    }
}
