package com.linktracker.linktracker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LinkDTO {
    private Integer id;
    private String url;
    private String password;
    private Boolean valid;
    private Integer redirectCount;

    public LinkDTO(int id, String url, String password) {
        this.id = id;
        this.url = url;
        this.password = password;
        this.valid = true;
        this.redirectCount = 0;
    }

    public LinkDTO(String url, String password) {
        this.id = id;
        this.url = url;
        this.password = password;
        this.valid = true;
        this.redirectCount = 0;
    }

    public LinkDTO(String url) {
        this.id = id;
        this.url = url;
        this.password = password;
        this.valid = true;
        this.redirectCount = 0;
    }

    public void incrementRedirectCount(){
        this.redirectCount++;
    }

    public boolean isValid() {
        return this.valid;
    }
}
