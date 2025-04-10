package com.mercadolibre.maolaya.ejercicio_links.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LinkDto implements Serializable {
    private Integer id;
    private String link;
    private Integer calls;
    private String password;

    public LinkDto(@JsonProperty("link") String link, @JsonProperty("password") String password) {
        this.link = link;
        this.password = password == null ? "" : password;
    }
}
