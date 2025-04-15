package co.com.mercadolibre.youtuber.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import co.com.mercadolibre.youtuber.exception.BlogAlreadyExistsException;
import co.com.mercadolibre.youtuber.model.EntradaBlog;

public class BlogRepositoryImpl implements BlogRepository {
    
    private Map<Long, EntradaBlog> blogMap = new HashMap<>();

    @Override
    public void save(EntradaBlog entradaBlog) {
        if(blogMap.containsKey(entradaBlog.getId())) {
            throw new BlogAlreadyExistsException("Ya existe una entrada de blog con el Id dado");
        }
        blogMap.put(entradaBlog.getId(), entradaBlog);
    }

    @Override
    public Optional<EntradaBlog> findById(Long id) {
        return Optional.ofNullable(blogMap.get(id));
    }

    @Override
    public List<EntradaBlog> findAll() {
        return new ArrayList<>(blogMap.values());
    }
}
