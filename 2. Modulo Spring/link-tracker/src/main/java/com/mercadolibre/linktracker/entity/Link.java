package com.mercadolibre.linktracker.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Link {
    private Long id;
    private String url;
    private String password;
    private Integer redirects;


    public void incrementRedirect(){
        redirects++;
    }

}
