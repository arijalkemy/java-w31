package com.mercadolibre.tracker.repository;

import com.mercadolibre.tracker.model.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepositoryImpl implements LinkRepository {

    private List<Link> links = new ArrayList<>();


    @Override
    public String createLink(Link link) {
        links.add(link);
        return link.getLinkId();
    }

    @Override
    public Boolean exists(String linkId) {
        return links.stream().anyMatch(l -> l.getLinkId().equalsIgnoreCase(linkId));
    }

    @Override
    public Boolean isActive(String linkId) {
        return links.stream().anyMatch(l -> l.getLinkId().equalsIgnoreCase(linkId) && l.getActive());
    }

    @Override
    public void updateVisitCounter(String linkId) {
        Link link = links.stream().filter(l -> l.getLinkId().equalsIgnoreCase(linkId)).findFirst().get();
        link.setVisitCounter(link.getVisitCounter() + 1);
    }

    @Override
    public Boolean passwordMatches(String linkId, String password) {
        Link link = links.stream().filter(l -> l.getLinkId().equalsIgnoreCase(linkId)).findFirst().get();
        return link.getPassword().equals(password);
    }

    @Override
    public Link getLinkById(String linkId) {
        Link link = links.stream().filter(l -> l.getLinkId().equalsIgnoreCase(linkId)).findFirst().get();
        return link;
    }

    @Override
    public Integer getMetricsById(String linkId) {
        return links.stream().filter(l -> l.getLinkId().equalsIgnoreCase(linkId)).findFirst().get().getVisitCounter();
    }

    @Override
    public void invalidate(String linkId) {
        links.stream().filter(l -> l.getLinkId().equalsIgnoreCase(linkId)).findFirst().get().setActive(Boolean.FALSE);
    }
}
