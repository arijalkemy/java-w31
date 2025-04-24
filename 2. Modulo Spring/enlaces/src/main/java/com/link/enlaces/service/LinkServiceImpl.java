package com.link.enlaces.service;

import com.link.enlaces.dto.ResponseDTO;
import com.link.enlaces.entity.Link;
import com.link.enlaces.repository.LinkRespository;
import com.link.enlaces.repository.LinkRespositoryImpl;

public class LinkServiceImpl implements LinkService{

    LinkRespository linkRespository= new LinkRespositoryImpl();
    @Override
    public ResponseDTO addLink(String newLink) {
        Link link = new Link(newLink );
        int IDlink = linkRespository.addLink(link);
        return new ResponseDTO(IDlink);
    }

    @Override
    public String redirectLink(int idLink, String password) {
        return linkRespository.redirectLink(idLink,password);
    }

    @Override
    public ResponseDTO getMetrics(int linkID) {
        return new ResponseDTO(linkRespository.getMetrics(linkID));
    }
}
