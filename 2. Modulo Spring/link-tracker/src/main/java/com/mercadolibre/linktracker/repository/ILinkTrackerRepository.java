package com.mercadolibre.linktracker.repository;

import com.mercadolibre.linktracker.model.LinkTracker;

import java.util.HashMap;

public interface ILinkTrackerRepository {

    HashMap<Integer, LinkTracker> findAllLinks();
    LinkTracker findLinkById(Integer id);
    void saveNewLink(LinkTracker linkTracker);
    void invalidateLink(Integer id);
}
