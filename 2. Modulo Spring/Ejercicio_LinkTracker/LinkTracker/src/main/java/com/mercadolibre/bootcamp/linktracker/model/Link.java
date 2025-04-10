package com.mercadolibre.bootcamp.linktracker.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
public class Link {

    private Long id;
    private String url;
    private String password;
    private Integer redirects;
    private Boolean valid;

    public Link(){
        redirects = 0;
        valid = Boolean.TRUE;
    }

    public void call(){
        this.redirects++;
    }

    @Override
    public String toString() {
        return "Link{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", password='" + password + '\'' +
                ", redirects=" + redirects +
                ", valid=" + valid +
                '}';
    }
}
