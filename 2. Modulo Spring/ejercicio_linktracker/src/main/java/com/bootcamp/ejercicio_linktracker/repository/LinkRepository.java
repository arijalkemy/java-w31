package com.bootcamp.ejercicio_linktracker.repository;

import com.bootcamp.ejercicio_linktracker.model.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepository implements ILinkRepository{
    private List<Link> links = new ArrayList<>();

    @Override
    public Integer saveLink(Link link) {
        links.add(link);
        return link.getId();
    }

    @Override
    public Integer getVisitCount(Integer linkId) {
        return 0;
    }

    @Override
    public Link getLinkById(Integer linkId) {
        return links.stream().filter(link -> link.getId().equals(linkId)).findFirst().orElse(null);
    }

    @Override
    public Link getRedirect(Integer linkId, String password) {
        return links.stream().filter(link -> link.getId().equals(linkId) && link.getPassword().equals(password)).findFirst().orElse(null);
    }
}
