package com.bootcamp.linktracker.model;

import com.bootcamp.linktracker.dto.LinkDto;
import lombok.Data;

@Data
public class Link {
    private Integer id;
    private String url;
    private Integer timesRedirected;
    private String password;
    private static int idsCounter = 0;

    public Link(String url, String password) {
        idsCounter++;
        this.id = idsCounter;
        this.url = url;
        this.password = password;
        this.timesRedirected = 0;
    }

    public static Link buildFromDto(LinkDto linkDto) {
        return new Link(linkDto.getUrl(),
                linkDto.getPassword());
    }
}
