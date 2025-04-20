package com.mercadolibreexample.link.dto.service;

import com.mercadolibreexample.link.dto.LinkDto;
import com.mercadolibreexample.link.exception.LinkInvalidException;
import com.mercadolibreexample.link.exception.LinkNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class LinkService {

    private final Map<Integer, LinkDto> links = new HashMap<>();
    private int currentId = 0;

    public int createLink(String url, String password) {
        LinkDto link = new LinkDto(currentId, url, password);
        links.put(currentId, link);
        return currentId++;
    }

    public String getRedirectUrl(int id, String password) {
        LinkDto link = links.get(id);
        if (link == null) throw new LinkNotFoundException(id);
        if (!link.isValid()) throw new LinkInvalidException(id);
        if (link.getPassword() != null && !link.getPassword().equals(password)) {
            throw new RuntimeException("Contraseña incorrecta"); // Podés hacerla más elegante
        }
        link.incrementRedirect();
        return link.getOriginalUrl();
    }

    public int getRedirectCount(int id) {
        LinkDto link = links.get(id);
        if (link == null) throw new LinkNotFoundException(id);
        return link.getRedirectCount();
    }

    public void invalidateLink(int id) {
        LinkDto link = links.get(id);
        if (link == null) throw new LinkNotFoundException(id);
        link.invalidate();
    }
}
