package com.link.enlaces.entity;

import java.util.Random;

public class Link {

    private Integer linkId;
    private String link;
    private String password;
    private Integer count;

    public Integer getLinkId() {
        return linkId;
    }

    public String getLink() {
        return link;
    }

    public String getPassword() {
        return password;
    }

    public void sumarContador(){
        count++;
    }
    public Integer getCount() {
        return count;
    }

    public Link(String link) {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(1000);
        this.linkId = numeroAleatorio;
        this.link = link;
        this.password = "pass" + linkId;
        count = 0;
    }
}
