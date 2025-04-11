package com.example.LinkTracker.DTO;

import java.io.Serializable;

import com.example.LinkTracker.Entities.Link;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LinkDTO implements Serializable {
    private Integer id;

    public LinkDTO(Integer id) {
        this.id = id;
    }

    public static LinkDTO linkToDTO(Link link) {
        return new LinkDTO(link.getId());
    }
}
