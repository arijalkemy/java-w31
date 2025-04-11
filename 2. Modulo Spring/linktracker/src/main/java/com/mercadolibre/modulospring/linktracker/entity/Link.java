package com.mercadolibre.modulospring.linktracker.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Link {
    private Integer id;
    private String link;
    private String password;
    private Boolean valid;
    private Integer numVisited;

}
