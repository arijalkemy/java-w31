package co.com.mercadolibre.youtuber.repository;

import java.util.List;
import java.util.Optional;

import co.com.mercadolibre.youtuber.model.EntradaBlog;

public interface BlogRepository {

    void save(EntradaBlog entradaBlog);
    Optional<EntradaBlog> findById(Long id);
    List<EntradaBlog> findAll();
}
