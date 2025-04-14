package com.bootcamp.ej_linktracker.model;

import lombok.Data;

@Data
public class LinkDto {
    private int id;
    private String url;
    private int visitCount;
    private boolean isActive;
    private String password; //redireccion

    public LinkDto(int id, String url, String password) {
        this.id = id;
        this.url = url;
        this.password = password;
        this.visitCount = 0;
        this.isActive = true;
    }

    public void incrementVisitCount() {
        this.visitCount++;
    }
}
