package com.linktracker.link.dto;

import java.io.Serializable;
import java.util.UUID;

public class LinkResponseDTO implements Serializable {
    private UUID linkId;
    private Integer counter;

    public LinkResponseDTO(UUID linkId, Integer counter) {
        this.counter = counter;
        this.linkId = linkId;
    }

    public LinkResponseDTO() {
    }

    public UUID getLinkId() {
        return linkId;
    }

    public Integer getCounter() {
        return counter;
    }
}