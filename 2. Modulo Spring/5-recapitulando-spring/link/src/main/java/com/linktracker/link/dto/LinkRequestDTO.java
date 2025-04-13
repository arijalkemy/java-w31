package com.linktracker.link.dto;

import java.io.Serializable;

public class LinkRequestDTO implements Serializable {
    private String link;
    private String password;

    public LinkRequestDTO(String link, String password) {
        this.link = link;
        this.password = password;
    }

    public LinkRequestDTO() {
    }

    public String getLink() {
        return link;
    }

    public String getPassword() {
        return password;
    }
}
