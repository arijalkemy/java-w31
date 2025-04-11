package com.mercadolibre.modulospring.linktracker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
@AllArgsConstructor
@Getter
public class ResponseLinkDTO implements Serializable {
    private Integer id;
    private String link;

}

