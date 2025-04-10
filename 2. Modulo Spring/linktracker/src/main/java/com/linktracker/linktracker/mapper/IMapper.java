package com.linktracker.linktracker.mapper;

import com.linktracker.linktracker.dto.LinkDTO;
import com.linktracker.linktracker.model.Link;

public interface IMapper {
    public LinkDTO linkTOLinkDTO(Link l);
    public Link LinkDTOToLink(LinkDTO l);
}
