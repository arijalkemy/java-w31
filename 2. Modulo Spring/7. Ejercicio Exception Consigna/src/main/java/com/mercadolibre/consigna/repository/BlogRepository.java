package com.mercadolibre.consigna.repository;

import com.mercadolibre.consigna.model.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BlogRepository {
    private final Map<Integer, EntradaBlog> blogMap = new HashMap<>();

    public EntradaBlog save(EntradaBlog blog) {
        return blogMap.put(blog.getId(), blog);
    }

    public EntradaBlog findById(Integer id) {
        return blogMap.get(id);
    }

    public Map<Integer, EntradaBlog> findAll() {
        return blogMap;
    }

    public boolean existsById(Integer id) {
        return blogMap.containsKey(id);
    }
}
