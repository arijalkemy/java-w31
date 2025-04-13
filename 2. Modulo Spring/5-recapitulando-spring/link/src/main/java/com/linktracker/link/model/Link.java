package com.linktracker.link.model;

public class Link {
    private String link;
    private Integer counter;
    private String password;

    public Link(Integer counter, String link, String password) {
        this.counter = counter;
        this.link = link;
        this.password = password;
    }

    public Integer getCounter() {
        return counter;
    }

    public String getLink() {
        return link;
    }

    public String getPassword() {
        return password;
    }

    public void addCounter() {
        counter++;
    }
}
