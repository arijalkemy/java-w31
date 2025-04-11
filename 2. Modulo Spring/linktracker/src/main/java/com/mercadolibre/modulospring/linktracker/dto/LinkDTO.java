package com.mercadolibre.modulospring.linktracker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class LinkDTO implements Serializable {
    private Integer id;
    private String link;
    private String password;

    public LinkDTO(Integer id, String link) {
        this.id = id;
        this.link = link;
        this.password="";
    }
}

