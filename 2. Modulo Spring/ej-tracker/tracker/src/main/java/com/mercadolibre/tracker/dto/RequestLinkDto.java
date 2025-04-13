package com.mercadolibre.tracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class RequestLinkDto {
    private String url;
    private String password;

    public RequestLinkDto(String url, String password) {
        this.url = url;
        this.password = password;
    }

    public RequestLinkDto() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
