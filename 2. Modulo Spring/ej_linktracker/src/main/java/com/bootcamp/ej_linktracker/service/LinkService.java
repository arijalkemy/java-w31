package com.bootcamp.ej_linktracker.service;

import com.bootcamp.ej_linktracker.exception.LinkNotFoundException;
import com.bootcamp.ej_linktracker.model.LinkDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LinkService {
    private final Map<Integer, LinkDto> links = new HashMap<>();
    private int idCounter =1;

    public int createLink(String url, String password) {
        LinkDto newLink = new LinkDto(idCounter,url,password);
        links.put(idCounter, newLink);
        idCounter++;
        return newLink.getId();
    }

    public LinkDto getLinkById(int id) {
        LinkDto linkDto = links.get(id);
        if (linkDto == null || !linkDto.isActive()) {
            throw new LinkNotFoundException(id);
        }
        return linkDto;
    }

    public void incrementVisitCount(int id) {
        LinkDto link = getLinkById(id);
        link.incrementVisitCount();
    }

    public int getVisitCount(int id) {
        LinkDto link = getLinkById(id);
        return link.getVisitCount();
    }

    public void invalidateLink(int id) {
        LinkDto link = getLinkById(id);
        link.setActive(false);
    }
}
