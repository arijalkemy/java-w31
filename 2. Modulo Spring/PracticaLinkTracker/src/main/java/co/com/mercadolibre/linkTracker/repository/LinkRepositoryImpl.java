package co.com.mercadolibre.linkTracker.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import co.com.mercadolibre.linkTracker.model.Link;

@Repository
public class LinkRepositoryImpl implements LinkRepository{

    private List<Link> linksDb = new ArrayList<>();

    @Override
    public List<Link> getAllLinks() {
        return linksDb;
    }

    @Override
    public Optional<Link> getLinkById(Long id) {
        return linksDb.stream()
        .filter(l -> l.getId().equals(id))
        .findFirst();
    }

    @Override
    public void save(Link link) {
        linksDb.add(link);
    }


    
}
