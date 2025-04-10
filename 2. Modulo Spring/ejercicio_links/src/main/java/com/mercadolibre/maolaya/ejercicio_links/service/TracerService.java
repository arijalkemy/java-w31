package com.mercadolibre.maolaya.ejercicio_links.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadolibre.maolaya.ejercicio_links.dto.LinkDto;
import com.mercadolibre.maolaya.ejercicio_links.exception.InvalidLinkException;
import com.mercadolibre.maolaya.ejercicio_links.model.Link;
import com.mercadolibre.maolaya.ejercicio_links.repository.TracerRepository;

@Service
public class TracerService {

    @Autowired
    TracerRepository tracerRepository;

    Integer idCounter = 1;

    public LinkDto createUrl(LinkDto linkDto) {
        Link link = new Link(idCounter, linkDto.getLink(), linkDto.getPassword());
        tracerRepository.save(link);
        linkDto.setCalls(link.getCalls());
        linkDto.setId(link.getId());
        idCounter++;
        return linkDto;
    }

    public Integer getMetricsByLink(Integer linkId) {
        Link link = tracerRepository.getLinkById(linkId);
        return link.getCalls();
    }

    public void invalidateLink(Integer linkId) {
        Link link = tracerRepository.getLinkById(linkId);
        link.invalidateLink();
    }

    public String getRedirectLink(Integer linkId) {
        Link link = tracerRepository.getLinkById(linkId);
        if (!link.getIsValid()) {
            throw new InvalidLinkException("Link invalido");
        }
        if (link.hasPassword()) {
            throw new InvalidLinkException("Contraseña requerida");
        }
        link.call();
        return link.getLink();
    }

    public String getRedirectLink(Integer linkId, String password) {
        Link link = tracerRepository.getLinkById(linkId);
        if (!link.getIsValid()) {
            throw new InvalidLinkException("Link invalido");
        }
        if (!link.validatePassword(password)) {
            throw new InvalidLinkException("Contraseña invalida");
        }
        link.call();
        return link.getLink();
    }

}
