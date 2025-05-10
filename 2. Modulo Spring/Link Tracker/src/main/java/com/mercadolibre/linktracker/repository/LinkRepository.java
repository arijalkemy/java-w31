package com.mercadolibre.linktracker.repository;

import com.mercadolibre.linktracker.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class LinkRepository implements ILinkRepository {

    private final Map<String, Link> links = new HashMap<>();

    @Override
    public Link save(Link link) {
        links.put(link.getLinkId(), link);
        return link;
    }

    @Override
    public Link findByLinkId(String linkId) {
        return links.get(linkId);
    }

    @Override
    public void delete(String linkId) {
        links.remove(linkId);
    }
}
