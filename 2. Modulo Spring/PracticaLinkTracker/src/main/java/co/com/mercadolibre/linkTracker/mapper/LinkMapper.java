package co.com.mercadolibre.linkTracker.mapper;

import co.com.mercadolibre.linkTracker.dto.LinkDto;
import co.com.mercadolibre.linkTracker.model.Link;

public class LinkMapper {

    public static Link LinkDtoToLink (LinkDto linkDto){
        return new Link(
            linkDto.getUrl(), 
            linkDto.getPassword(), 
            linkDto.isValid(), 
            linkDto.getRedirectCount());
    }

    public static LinkDto LinkToLinkDto (Link link){
        return new LinkDto(
            link.getUrl(), 
            link.getPassword(), 
            link.isValid(), 
            link.getRedirectCount());
    }
}
