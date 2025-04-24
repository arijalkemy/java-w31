package com.link.enlaces.repository;

import com.link.enlaces.entity.Link;

public interface LinkRespository {
    int addLink(Link link);

    String redirectLink(int idLink, String password);

    int getMetrics(int linkID);
}
