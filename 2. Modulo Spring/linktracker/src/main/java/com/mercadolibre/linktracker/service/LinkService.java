package com.mercadolibre.linktracker.service;

import com.mercadolibre.linktracker.dto.LinkDTO;
import com.mercadolibre.linktracker.dto.LinkStatsDTO;
import com.mercadolibre.linktracker.entity.Link;
import com.mercadolibre.linktracker.exception.LinkNotFoundException;
import com.mercadolibre.linktracker.exception.NoSePudoCrearElLinkException;
import com.mercadolibre.linktracker.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class LinkService implements ILinkService{
    @Autowired
    LinkRepository linkRepo;
    AtomicInteger counter = new AtomicInteger(1);


    @Override
    public Integer createLink(String url, String password) {
        if (url == null || !url.matches("^(http|https)://.*$")) {
            throw new NoSePudoCrearElLinkException("URL inválida");
        }

        Integer newId = counter.getAndIncrement();
        Link link = new Link(newId, url, password, 0);
        linkRepo.saveLink(link);
        return newId;
    }

    @Override
    public LinkDTO handleRedirect(Integer id, String password) {
        Link link = linkRepo.getById(id);

        if (link == null) {
            throw new LinkNotFoundException("No se pudo encontrar ese link");
        }

        if (link.getPassword() != null && (password == null || !link.getPassword().equals(password))) {
            throw new LinkNotFoundException("Contraseña invalida.");
        }

        link.setRedirectCount(link.getRedirectCount() + 1);
        return new LinkDTO(link.getPassword(), link.getUrl());
    }

    @Override
    public LinkStatsDTO getMetrics(Integer id) {
        Link link = linkRepo.getById(id);

        if (link == null) {
            throw new LinkNotFoundException("No se pudo encontrar ese link");
        }

        return new LinkStatsDTO(link.getId(), link.getRedirectCount());
    }

    @Override
    public void invalidateLink(Integer id, String password) {
        Link link = linkRepo.getById(id);
        if(link == null){
            throw new LinkNotFoundException("No se pudo encontrar ese link");
        }
        linkRepo.invalidateLink(id);
    }
}


