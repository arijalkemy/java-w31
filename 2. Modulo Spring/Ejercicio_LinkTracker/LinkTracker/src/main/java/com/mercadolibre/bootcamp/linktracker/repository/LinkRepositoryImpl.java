package com.mercadolibre.bootcamp.linktracker.repository;

import com.mercadolibre.bootcamp.linktracker.model.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class LinkRepositoryImpl implements ILinkRepository{

    HashMap<Long, Link> links = new HashMap<>();

    {
        links.put(1L, new Link(1L, "https://www.google.com", null, 0, true));
        links.put(2L, new Link(2L, "https://www.wikipedia.org", null, 0, true));
        links.put(3L, new Link(3L, "https://www.github.com", null, 0, true));
    }

    @Override
    public List<Link> findAll() {
        return new ArrayList<>(links.values());
    }

    @Override
    public Link save(Link link) {
        links.put(link.getId(), link);
        System.out.println(links.values().toString());
        return links.get(link.getId());
    }

    @Override
    public Link findById(Long id){
        return links.get(id);
    }


}
