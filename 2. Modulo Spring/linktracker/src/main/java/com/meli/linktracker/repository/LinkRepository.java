package com.meli.linktracker.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.meli.linktracker.model.LinkModel;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class LinkRepository {
    private final Map<String, LinkModel> links = new HashMap<String, LinkModel>();

    public LinkModel createLink(LinkModel link) {
        links.put(link.getId(), link);
        return link;
    }

    public LinkModel getLinkById(String id) {
        return links.get(id);
    }

    public LinkModel invalidateLinkById(String id) {
        LinkModel link = links.get(id);
        link.setActive(false);
        return link;
    }
}
