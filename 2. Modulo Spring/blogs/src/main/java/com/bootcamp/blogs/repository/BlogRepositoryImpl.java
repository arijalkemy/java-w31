package com.bootcamp.blogs.repository;

import com.bootcamp.blogs.entity.EntryBlog;
import com.bootcamp.blogs.exception.YaExisteException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepositoryImpl implements BlogRepository{

    List<EntryBlog> entries;

    public BlogRepositoryImpl() {
        this.entries = new ArrayList<>();
    }

    @Override
    public EntryBlog create(EntryBlog req){
        if(exists(req)){
            throw new YaExisteException("Ya existe un blog con ese id");
        }
        entries.add(req);
        return req;
    }

    @Override
    public Boolean exists(EntryBlog req) {
        return entries.stream().anyMatch(p -> p.getId().equals(req.getId()));
    }
}
