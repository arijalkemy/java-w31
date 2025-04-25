package com.example.ejlinkertracker.repository;

import com.example.ejlinkertracker.model.LinkTacker;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class LinkRepository implements ILinkRepository{
    List<LinkTacker> linkList = new ArrayList<>();


    public LinkRepository() {
        loadDataBase();
    }

    private void loadDataBase(){
        LinkTacker link1 = new LinkTacker(1L, "meli.com", 0, true, "222");
        LinkTacker link2 = new LinkTacker(2L, "facebook.com", 0, true, "333");

        linkList.add(link1);
        linkList.add(link2);
    }

    @Override
    public List<LinkTacker> findAll() {
        return linkList;
    }
}
