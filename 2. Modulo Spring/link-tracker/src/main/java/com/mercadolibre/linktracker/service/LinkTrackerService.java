package com.mercadolibre.linktracker.service;

import com.mercadolibre.linktracker.dto.LinkTrackerDTO;
import com.mercadolibre.linktracker.dto.LinkTrackerStatsDTO;
import com.mercadolibre.linktracker.exception.InvalidLinkException;
import com.mercadolibre.linktracker.exception.InvalidPasswordException;
import com.mercadolibre.linktracker.exception.LinkNotFoundException;
import com.mercadolibre.linktracker.model.LinkTracker;
import com.mercadolibre.linktracker.repository.ILinkTrackerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkTrackerService implements ILinkTrackerService {

    @Autowired
    private ILinkTrackerRepository linkRepository;


    @Override
    public Integer createUrl(String url, String password) {
        if (url == null || !url.matches("^(http|https)://.*$")) {
            throw new InvalidLinkException("Url inválida");
        }
        LinkTracker newLink = new LinkTracker(url, password);
        linkRepository.saveNewLink(newLink);
        return newLink.getId();
    }

    @Override
    public LinkTrackerDTO redirectLink(Integer id, String password) {
        LinkTracker linkFound = linkRepository.findLinkById(id);
        if (linkFound == null) {
            throw new LinkNotFoundException("No existe un link con ese id");
        }
        if (linkFound.getPassword() != null &&
                (password == null || !linkFound.getPassword().equals(password))) {
            throw new InvalidPasswordException("Contraseña inválida");
        }
        if (!linkFound.getValid()) {
            throw new InvalidLinkException("El link no es válido");
        }
        linkFound.setRedirectionCount(linkFound.getRedirectionCount() + 1);
        return new LinkTrackerDTO(id, linkFound.getUrl());
    }

    @Override
    public LinkTrackerStatsDTO getUrlMetrics(Integer id) {
        LinkTracker linkFound = linkRepository.findLinkById(id);
        if (linkFound == null) {
            throw new LinkNotFoundException("No existe un link con ese id");
        }
        return new LinkTrackerStatsDTO(id, linkFound.getRedirectionCount());
    }

    @Override
    public LinkTrackerDTO invalidateUrl(Integer id, String password) {
        LinkTracker linkFound = linkRepository.findLinkById(id);
        if (linkFound == null) {
            throw new LinkNotFoundException("No existe un link con ese id");
        }
        if (linkFound.getPassword() != null &&
                (!linkFound.getPassword().equals(password))) {
            throw new InvalidPasswordException("Contraseña inválida");
        }

        linkRepository.invalidateLink(id);

        return new LinkTrackerDTO(id, linkFound.getUrl());
    }
}
