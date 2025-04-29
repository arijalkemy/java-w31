package com.bootcamp.blogs.repository;

import com.bootcamp.blogs.entity.EntryBlog;

public interface BlogRepository {
    public EntryBlog create(EntryBlog req) throws Exception;
    public Boolean exists(EntryBlog req);
}
