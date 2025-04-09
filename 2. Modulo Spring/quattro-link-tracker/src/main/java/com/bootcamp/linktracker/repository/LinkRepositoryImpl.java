package com.bootcamp.linktracker.repository;

import com.bootcamp.linktracker.model.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepositoryImpl implements ILinkRepository {
    private List<Link> links = new ArrayList<>();

    @Override
    public Link add(Link link) {
        links.add(link);
        return link;
    }

    @Override
    public Link getById(Integer id) {
        return links.stream().filter(l -> l.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Boolean removeById(Integer id) {
        links.remove(getById(id));
        return true;
    }

    @Override
    public Link update(Integer id) {
        links.stream().filter(l -> l.getId().equals(id)).findFirst()
                .ifPresent(l -> l.setTimesRedirected(l.getTimesRedirected() + 1));

        return getById(id);
    }


}
