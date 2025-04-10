package com.mercadolibre.linktracker.repository;

import com.mercadolibre.linktracker.entity.Link;

public interface ILinkRepository {
    Long save(Link link);
    Link findById(Long id);

}
