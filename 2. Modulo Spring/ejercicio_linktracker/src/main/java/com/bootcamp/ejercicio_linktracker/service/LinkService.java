package com.bootcamp.ejercicio_linktracker.service;

import com.bootcamp.ejercicio_linktracker.dto.CreateLinkDto;
import com.bootcamp.ejercicio_linktracker.exception.NotFoundException;
import com.bootcamp.ejercicio_linktracker.model.Link;
import com.bootcamp.ejercicio_linktracker.repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkService implements ILinkService{
    @Autowired
    private ILinkRepository linkRepository;

    @Override
    public Integer getVisitCount(Integer linkId) {
        Link link = linkRepository.getLinkById(linkId);
        if(link == null || !link.getIsValid()){
            throw new NotFoundException("No se encontró el link");
        }
        return link.getVisitCount();
    }

    @Override
    public Integer saveLink(CreateLinkDto createLinkDto) {
        return linkRepository.saveLink(new Link(createLinkDto.getUrl(), createLinkDto.getPassword()));
    }

    @Override
    public String getRedirect(Integer linkId, String password) {
        Link link = linkRepository.getRedirect(linkId, password);
        if(link == null || !link.getIsValid()){
            throw new NotFoundException("No se encontró el link");
        }
        link.setVisitCount(link.getVisitCount() + 1);
        return link.getUrl();
    }

    @Override
    public void invalidateLink(Integer linkId) {
        Link link = linkRepository.getLinkById(linkId);
        if(link == null){
            throw new NotFoundException("No se encontró el link");
        }
        link.setIsValid(false);
    }
}
