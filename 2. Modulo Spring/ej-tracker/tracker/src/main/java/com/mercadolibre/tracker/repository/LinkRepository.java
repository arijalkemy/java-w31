package com.mercadolibre.tracker.repository;

import com.mercadolibre.tracker.model.Link;

public interface LinkRepository {

    String createLink(Link link);

    Boolean exists(String linkId);

    Boolean isActive(String linkId);

    Link getLinkById(String linkId);

    void updateVisitCounter(String linkId);

    Boolean passwordMatches(String linkId, String password);

    Integer getMetricsById(String linkId);

    void invalidate(String linkId);
}
