package com.mercadolibre.tracker.model;

import lombok.*;

public class Link {
    private String linkId;
    private String url;
    private Boolean active;
    private Integer visitCounter;
    private String password;

    public Link(String linkId, String url, Boolean active, Integer visitCounter, String password) {
        this.linkId = linkId;
        this.url = url;
        this.active = active;
        this.visitCounter = visitCounter;
        this.password = password;
    }

    public Link() {
    }

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getVisitCounter() {
        return visitCounter;
    }

    public void setVisitCounter(Integer visitCounter) {
        this.visitCounter = visitCounter;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
