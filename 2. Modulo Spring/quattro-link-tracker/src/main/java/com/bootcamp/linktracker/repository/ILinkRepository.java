package com.bootcamp.linktracker.repository;

import com.bootcamp.linktracker.model.Link;

public interface ILinkRepository {
    Link add(Link link);
    Link getById(Integer id);
    Boolean removeById(Integer id);
    Link update(Integer id);
}
