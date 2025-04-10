package com.linktracker.linktracker.mapper;

import com.linktracker.linktracker.dto.LinkDTO;
import com.linktracker.linktracker.model.Link;
import org.springframework.stereotype.Component;

@Component
public class MapperImpl implements IMapper{

    @Override
    public LinkDTO linkTOLinkDTO(Link l) {
        LinkDTO linkDTO = new LinkDTO(l.getId(),
                l.getUrl(),
                l.getPassword(),
                l.getValid(),
                l.getRedirectCount());
        return linkDTO;
    }

    @Override
    public Link LinkDTOToLink(LinkDTO l) {
        Link link = new Link(
                l.getId(),
                l.getUrl(),
                l.getPassword(),
                l.getValid(),
                l.getRedirectCount());
        return link;
    }
}
