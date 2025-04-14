package com.mercadolibre.linktracker.repository;

import com.mercadolibre.linktracker.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
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
        link.setRedirects(0);
        linkList.add(link);

        return link.getId();
    }

    @Override
    public Optional<Link> findById(Long id) {
        return linkList.stream()
                .filter(l -> l.getId().equals(id))
                .findFirst();
    }

    @Override
    public Optional<Link> findByUrl(String url) {
        return linkList
                .stream()
                .filter(l -> l.getUrl().equalsIgnoreCase(url))
                .findFirst();
    }

    @Override
    public void redirectLink(Long id) {
        linkList.forEach( l ->{
            if (l.getId().equals(id)){
                l.incrementRedirect();
            }
        });
    }

}
