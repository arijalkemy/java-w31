package com.linktracker.linktracker.repository;

import com.linktracker.linktracker.dto.LinkDTO;
import com.linktracker.linktracker.model.Link;

import java.util.HashMap;

public interface ILinkRepository {
    public void save(LinkDTO link);
    public Link findById(int id);
    public HashMap<Integer, Link> getAll();
    public void invalidate(int id);
}
