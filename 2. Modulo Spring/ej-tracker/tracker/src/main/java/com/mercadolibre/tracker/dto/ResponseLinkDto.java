package com.mercadolibre.tracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ResponseLinkDto {
    private String linkId;

    public ResponseLinkDto(String linkId) {
        this.linkId = linkId;
    }

    public ResponseLinkDto() {
    }

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }
}
