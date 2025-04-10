package org.ejercicios.linktracker.repository;

import org.ejercicios.linktracker.entity.Link;
import org.ejercicios.linktracker.exception.NotFoundException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Random;

@Repository
public class LinkRepository {
    private HashMap<Integer, Link> links;
    private final Random random;

    public LinkRepository() {
        links = new HashMap<>();
        random = new Random();
    }

    public int createLink(String originalLink) {
        int randomInt = random.nextInt(100000);
        Link link = new Link(originalLink, 0, true);

        links.put(randomInt, link);
        return randomInt;
    }

    public Link getLinkFromID(int id) {
        return links.get(id);
    }

    public void addToLinkCounter(int id) {
        Link link = links.get(id);

        if (link != null) {
            link.setCount(link.getCount() + 1);
        }
    }

    public boolean invalidateLink(int id) {
        Link link = links.get(id);

        if(link == null || !link.isValid()) {
            return false;
        }

        link.setValid(false);
        return true;
    }
}
