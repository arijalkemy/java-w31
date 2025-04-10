package com.mercadolibre.linktracker.repository;

import com.mercadolibre.linktracker.model.LinkTracker;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class LinkTrackerRepository implements ILinkTrackerRepository {
    private HashMap<Integer, LinkTracker> linkRepository;

    public LinkTrackerRepository() {
        linkRepository = new HashMap<>();
    }

    @Override
    public HashMap<Integer, LinkTracker> findAllLinks() {
        return linkRepository;
    }

    public LinkTracker findLinkById(Integer id) {
        return linkRepository.get(id);
    }

    @Override
    public void saveNewLink(LinkTracker linkTracker) {
        linkRepository.put(linkTracker.getId(), linkTracker);
    }

    @Override
    public void invalidateLink(Integer id) {
        linkRepository.get(id).setValid(false);
    }

}
