package com.mercadolibre.linktracker.dto;

import com.mercadolibre.linktracker.entity.Link;

public class LinkMapper {


    public static Link linkDtoToLink(LinkDto linkDto){
        Link link = new Link();

        link.setUrl(linkDto.getUrl());

        if (linkDto.getPassword() != null){
            link.setPassword(linkDto.getPassword());
        }

        return link;
    }

    public static LinkDto linkToLinkDto(Link link){
        LinkDto linkReturn = new LinkDto();

        linkReturn.setUrl(link.getUrl());
        linkReturn.setRedirects(link.getRedirects());

        if (link.getPassword() != null){
            linkReturn.setPassword(link.getPassword());
        }

        return linkReturn;
    }



}
