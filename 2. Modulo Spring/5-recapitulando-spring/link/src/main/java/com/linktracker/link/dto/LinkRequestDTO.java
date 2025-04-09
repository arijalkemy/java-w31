package com.linktracker.link.dto;

import java.io.Serializable;

public class LinkRequestDTO implements Serializable {
    private String link;

    public LinkRequestDTO(String link) {
        this.link = link;
    }

    public LinkRequestDTO() {
    }

    public String getLink() {
        return link;
    }
}
