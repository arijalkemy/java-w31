package com.mercadolibre.maolaya.ejercicio_links.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.mercadolibre.maolaya.ejercicio_links.model.Link;

@Repository
public class TracerRepository {

    Map<Integer, Link> links = new HashMap<>();

    public void save(Link link) {
        links.put(link.getId(), link);
    }

    public Link getLinkById(Integer linkId) {
        return links.get(linkId);
    }

}
