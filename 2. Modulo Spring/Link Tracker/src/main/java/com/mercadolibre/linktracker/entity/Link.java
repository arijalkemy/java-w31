package com.mercadolibre.linktracker.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Link {
    private String linkId;
    private String url;
    private String password;
    private int redirectionCount;

    public Link(String linkId, String url, String password, int redirectionCount) {
        this.linkId = linkId;
        this.url = url;
        this.password = password;
        this.redirectionCount = redirectionCount;
    }
}
