package co.com.mercadolibre.linkTracker.repository;

import java.util.List;
import java.util.Optional;

import co.com.mercadolibre.linkTracker.model.Link;

public interface LinkRepository {

    Optional<Link> getLinkById (Long id);
    List<Link> getAllLinks ();
    void save (Link link);
}
