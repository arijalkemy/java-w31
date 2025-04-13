package com.linktracker.link.repository;

import com.linktracker.link.exception.IdNotFoundException;
import com.linktracker.link.model.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.UUID;

@Repository
public class LinkRepository {

    private HashMap<UUID, Link> links = new HashMap<>();

    public UUID addLink(Link link) {
        UUID key = UUID.randomUUID();
        links.put(key, link);
        return key;
    }

    public void redirectToLink(UUID linkId) {
        boolean exists = links.containsKey(linkId);
        if (!exists) {
            throw new IdNotFoundException("Link " + linkId + " not found");
        }
        Link link = links.get(linkId);
        link.addCounter();
    }

    public Link getMetrics(UUID linkId) {
        boolean exists = links.containsKey(linkId);
        if (!exists) {
            throw new IdNotFoundException("Link " + linkId + " not found");
        }
        Link link = links.get(linkId);
        return link;
    }

}
