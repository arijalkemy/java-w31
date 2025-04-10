package com.linktracker.linktracker.repository;

import com.linktracker.linktracker.dto.LinkDTO;
import com.linktracker.linktracker.mapper.IMapper;
import com.linktracker.linktracker.model.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class LinkRepositoryImpl implements ILinkRepository {

    @Autowired
    IMapper mapper;

    private final HashMap<Integer, Link> bd = new HashMap<>();

    @Override
    public void save(LinkDTO link) {
        Link link1 = mapper.LinkDTOToLink(link);
        bd.put(link.getId(),link1);
    }

    @Override
    public Link findById(int id) {
        return bd.get(id);
    }

    @Override
    public void invalidate(int id) {
        bd.get(id).setValid(false);
    }

    @Override
    public HashMap<Integer,Link> getAll() {
        return bd;
    }
}
