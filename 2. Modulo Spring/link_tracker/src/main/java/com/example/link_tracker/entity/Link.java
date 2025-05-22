package com.example.link_tracker.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Link {
    private String id;
    private String url;
    private String password;
    private int redirectionCount;

    public Link(String id, String url, String password, int redirectionCount) {
        this.id = id;
        this.url = url;
        this.password = password;
        this.redirectionCount = redirectionCount;
    }
}
