package com.bootcamp.linktracker.dto;

import com.bootcamp.linktracker.model.Link;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LinkDto implements Serializable {
    private Integer id;
    private String url;
    private Integer timesRedirected;
    private String password;

    public static LinkDto buildFromLink(Link link) {
        return new LinkDto(
                link.getId(),
                link.getUrl(),
                link.getTimesRedirected(),
                link.getPassword()
        );
    }
}
