package com.example.LinkTracker.Entities;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Link {
    private Integer id;
    private String url;
    private Integer numberOfRedirections;
    private Boolean isValid;

    public Link(String url, Integer id) {
        this.url = url;
        this.id = id;
        this.numberOfRedirections = 0;
        this.isValid = true;
    }

    public void addRedirection() {
        this.numberOfRedirections++;
    }
}