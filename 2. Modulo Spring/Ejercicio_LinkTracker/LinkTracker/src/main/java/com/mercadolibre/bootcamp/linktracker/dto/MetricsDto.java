package com.mercadolibre.bootcamp.linktracker.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MetricsDto {
    private String url;
    private Integer redirects;
}
