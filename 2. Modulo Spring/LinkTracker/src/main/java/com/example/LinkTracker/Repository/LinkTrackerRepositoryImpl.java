package com.example.LinkTracker.Repository;

import org.springframework.stereotype.Repository;
import com.example.LinkTracker.Entities.Link;

import java.util.List;
import java.util.ArrayList;

@Repository
public class LinkTrackerRepositoryImpl implements LinkTrackerRepository {
    private List<Link> links;

    public LinkTrackerRepositoryImpl() {
        this.links = new ArrayList<Link>();
    }

    @Override
    public void newLink(Link link) {
        this.links.add(link);
    }

    @Override
    public boolean isLinkPresent(Link link) {
        for (Link l : links) {
            if (l.getId() == link.getId() || l.getUrl().equals(link.getUrl())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Link findLinkById(Integer id) {
        return links.stream()
                .filter(l -> l.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Integer getNumbreOfRedirections(Integer id) {
        Link link = findLinkById(id);
        return link == null ? null : link.getNumberOfRedirections();
    }

    @Override
    public Boolean addRedirection(Integer id) {
        Link link = findLinkById(id);
        if (link == null) {
            return false;
        }

        link.addRedirection();
        return true;
    }

    @Override
    public Boolean invalidateLink(Integer id) {
        Link link = findLinkById(id);
        if (link == null) {
            return false;
        }
        link.setIsValid(false);
        return true;
    }
}
