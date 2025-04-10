package com.mercadolibre.bootcamp.linktracker.repository;

import com.mercadolibre.bootcamp.linktracker.model.Link;

import java.util.List;

public interface ILinkRepository {
    List<Link> findAll();

    Link save(Link link);

    Link findById(Long id);
}
