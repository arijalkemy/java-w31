package com.mercadolibre.linktracker.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class LinkTrackerRequestDTO {
    private String url;
    private String password;
}
