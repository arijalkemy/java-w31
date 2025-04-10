package com.mercadolibre.linktracker.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Link {
    private Integer id;
    private String url;
    private String password;
    private Integer redirectCount = 0;
}
