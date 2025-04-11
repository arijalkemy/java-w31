package com.mercadolibre.modulospring.linktracker.repository;

import com.mercadolibre.modulospring.linktracker.dto.LinkDTO;
import com.mercadolibre.modulospring.linktracker.dto.ResponseLinkDTO;
import com.mercadolibre.modulospring.linktracker.entity.Link;

public interface ILinkRepository {
    void addLink(Link link);
    Link getLink(Integer id);
    Boolean invalidlink(Integer id);
}
