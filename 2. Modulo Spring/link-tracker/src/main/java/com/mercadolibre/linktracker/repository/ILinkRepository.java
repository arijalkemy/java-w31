package com.mercadolibre.linktracker.repository;

import com.mercadolibre.linktracker.entity.Link;

import java.util.Optional;

public interface ILinkRepository {
    Long save(Link link);
    Optional<Link> findById(Long id);
    Optional<Link> findByUrl(String url);
    void redirectLink(Long id);
}
