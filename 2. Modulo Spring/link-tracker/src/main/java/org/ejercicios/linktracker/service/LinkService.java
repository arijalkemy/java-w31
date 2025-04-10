package org.ejercicios.linktracker.service;

import org.ejercicios.linktracker.dto.LinkDTO;
import org.ejercicios.linktracker.entity.Link;
import org.ejercicios.linktracker.exception.NotFoundException;
import org.ejercicios.linktracker.repository.LinkRepository;
import org.springframework.stereotype.Service;

@Service
public class LinkService {
    private LinkRepository repository;

    public LinkService(LinkRepository repository) {
        this.repository = repository;
    }

    public int createLink(String originalLink) {
        return repository.createLink(originalLink);
    }

    public String getLinkFromID(int id) {
        Link link = repository.getLinkFromID(id);

        if(link == null || !link.isValid()) {
            throw new NotFoundException("Link not found");
        }

        repository.addToLinkCounter(id);
        return link.getLink();
    }

    public int getLinkCount(int id) {
        Link link = repository.getLinkFromID(id);
        if(link == null || !link.isValid()) {
            throw new NotFoundException("Link not found");
        }

        return link.getCount();
    }

    public void invalidateLink(int id) {
        if(!this.repository.invalidateLink(id)) {
            throw new NotFoundException("Link not found");
        }
    }
}
