package com.linktracker.link.service;

import com.linktracker.link.dto.LinkRequestDTO;
import com.linktracker.link.dto.LinkResponseDTO;
import com.linktracker.link.model.Link;
import com.linktracker.link.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LinkService {

    @Autowired
    private LinkRepository linkRepository;

    public LinkResponseDTO addLink(LinkRequestDTO linkDTO) {
        Link link = new Link(0, linkDTO.getLink(), linkDTO.getPassword());
        UUID key = linkRepository.addLink(link);
        return new LinkResponseDTO(key, 0);
    }

    public void redirectToLink(UUID linkId) {
        linkRepository.redirectToLink(linkId);
    }

    public LinkResponseDTO getMetrics(UUID linkId) {
        Link link = linkRepository.getMetrics(linkId);
        return new LinkResponseDTO(linkId, link.getCounter());
    }

}
