package com.mercadolibreexample.link.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class LinkDto {
    private Integer id;
    private String originalUrl;
    private int redirectCount;
    private boolean isValid = true;
    private String password;

    public LinkDto(Integer id, String originalUrl, String password) {}

    public void incrementRedirect() { redirectCount++; }
    public void invalidate() { isValid = false; }
}
