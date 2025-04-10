package com.mercadolibre.blogapi.repository;

import com.mercadolibre.blogapi.model.Blog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepository implements IBlogRepository {

    private List<Blog> listaBlog;

    public BlogRepository() {
        listaBlog = loadData();
    }

    public List<Blog> loadData(){
        List<Blog> listaBlog = new ArrayList<>();

        return listaBlog;
    }

    @Override
    public Long save(Blog entradaBlog) {
        listaBlog.add(entradaBlog);
        return entradaBlog.getId();
    }

    @Override
    public Blog findById(Long id) {
        return listaBlog
                .stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElse(null);
    }


}
