package com.bootcamp.ejercicio_linktracker.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Link {
    private static Integer generatedId = 0;
    private Integer id;
    private String url;
    private Integer visitCount;
    private Boolean isValid;
    private String password;

    public Link(String url, String password) {
        this.id = ++generatedId;
        this.url = url;
        this.password = password;
    }
}
