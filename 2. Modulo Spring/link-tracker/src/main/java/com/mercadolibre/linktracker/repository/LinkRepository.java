package com.mercadolibre.linktracker.repository;

import com.mercadolibre.linktracker.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class LinkRepository implements ILinkRepository{

    private List<Link> linkList;
    private AtomicLong idCount = new AtomicLong(0);

    public LinkRepository(List<Link> linkList) {
        this.linkList = linkList;
    }

    @Override
    public Long save(Link link) {
        Long id = idCount.incrementAndGet();
        link.setId(id);
        linkList.add(link);

        return link.getId();
    }

    @Override
    public Link findById(Long id) {
        return linkList.stream()
                .filter(l -> l.getId().equals(id))
                .findFirst()
                .get();
    }
}
