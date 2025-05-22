package com.example.link_tracker.repository;

import com.example.link_tracker.entity.Link;

import java.util.HashMap;
import java.util.Map;

public class LinkRepository implements ILinkRepository{
    private final Map<String, Link> links = new HashMap<>();

    @Override
    public Link save(Link link) {
        links.put(link.getId(), link);
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
