package com.mercadolibre.linktracker.repository;

import com.mercadolibre.linktracker.dto.LinkDTO;
import com.mercadolibre.linktracker.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class LinkRepository implements ILinkRepository{
    HashMap<Integer, Link> links = new HashMap<>();

    @Override
    public void saveLink(Link link) {
        this.links.put(link.getId(), link);
    }

    @Override
    public Link getById(Integer id){
        return this.links.get(id);
    }

    @Override
    public void invalidateLink(Integer id) {
        this.links.remove(id);
    }

}
