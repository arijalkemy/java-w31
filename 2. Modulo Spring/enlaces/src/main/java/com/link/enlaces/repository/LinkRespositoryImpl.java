package com.link.enlaces.repository;

import com.link.enlaces.entity.Link;

import java.util.HashMap;
import java.util.Map;

public class LinkRespositoryImpl implements LinkRespository{

    Map<Integer, Link> links = new HashMap<>();
    @Override
    public int addLink(Link link) {
        links.put(link.getLinkId(), link);
        return link.getLinkId();
    }

    @Override
    public String redirectLink(int idLink, String password) {
        Link link = links.get(idLink);
        if(password.equals(link.getPassword())){
            link.sumarContador();
            return link.getLink();
        }
            return "";
        }

    @Override
    public int getMetrics(int linkID) {
        return links.get(linkID).getCount();
    }
}
