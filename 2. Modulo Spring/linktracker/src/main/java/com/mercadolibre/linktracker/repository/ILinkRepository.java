package com.mercadolibre.linktracker.repository;

import com.mercadolibre.linktracker.dto.LinkDTO;
import com.mercadolibre.linktracker.entity.Link;

import java.util.HashMap;

public interface ILinkRepository {
    public void saveLink(Link link);
    public Link getById(Integer id);
    void invalidateLink(Integer id);
}
