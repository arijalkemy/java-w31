package com.example.link_tracker.repository;

import com.example.link_tracker.entity.Link;

public interface ILinkRepository {
    Link save(Link link);
    Link findByLinkId(String id);
    void delete(String id);
}
