package com.mercadolibre.tracker.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.tracker.dto.RequestLinkDto;
import com.mercadolibre.tracker.dto.ResponseLinkDto;
import com.mercadolibre.tracker.exception.InvalidatedLinkException;
import com.mercadolibre.tracker.exception.NotFoundException;
import com.mercadolibre.tracker.exception.WrongCredentialsException;
import com.mercadolibre.tracker.model.Link;
import com.mercadolibre.tracker.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImpl implements LinkService {

    @Autowired
    LinkRepository linkRepository;
    @Override
    public ResponseLinkDto createLink(RequestLinkDto requestLink) {
        Link link = new Link(String.valueOf(Math.random()), requestLink.getUrl(), Boolean.TRUE, 0, requestLink.getPassword());

        return new ResponseLinkDto(linkRepository.createLink(link));
    }

    @Override
    public String redirect(String linkId, String password) {
        if (!linkRepository.exists(linkId)) {
            throw new NotFoundException("No existe un link con ese id.");
        }

        if (!linkRepository.isActive(linkId)) {
            throw new InvalidatedLinkException("El link esta invalidado.");
        }

        if (!linkRepository.passwordMatches(linkId, password)) {
            throw new WrongCredentialsException("La contraseña no es correcta.");
        }

        linkRepository.updateVisitCounter(linkId);

        return linkRepository.getLinkById(linkId).getUrl();
    }

    @Override
    public Integer getMetrics(String linkId) {
        if (!linkRepository.exists(linkId)) {
            throw new NotFoundException("No existe un link con ese id.");
        }

        return linkRepository.getMetricsById(linkId);
    }

    @Override
    public String invalidate(String linkId) {
        if (!linkRepository.exists(linkId)) {
            throw new NotFoundException("No existe un link con ese id.");
        }

        if (!linkRepository.isActive(linkId)) {
            throw new InvalidatedLinkException("El link ya esta invalidado.");
        }

        linkRepository.invalidate(linkId);
        return "Link invalidado exitosamente";
    }
}
