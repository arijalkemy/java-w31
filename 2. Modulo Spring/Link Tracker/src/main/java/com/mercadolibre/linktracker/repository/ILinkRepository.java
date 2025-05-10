package com.mercadolibre.linktracker.repository;

import com.mercadolibre.linktracker.entity.Link;

public interface ILinkRepository {

    Link save(Link link);

    Link findByLinkId(String linkId);

    void delete(String linkId);
}
