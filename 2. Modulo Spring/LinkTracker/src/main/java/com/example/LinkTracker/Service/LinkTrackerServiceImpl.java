package com.example.LinkTracker.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LinkTracker.DTO.LinkDTO;
import com.example.LinkTracker.Entities.Link;
import com.example.LinkTracker.Exceptions.*;
import com.example.LinkTracker.Repository.LinkTrackerRepository;

@Service
public class LinkTrackerServiceImpl implements LinkTrackerService {
    @Autowired
    LinkTrackerRepository linkTrackerRepository;

    private Boolean isUrlValid(String url) {
        String expectedPrefix = "https://";
        if (url == null || url.isEmpty()) {
            return false;
        }

        if (url.length() < expectedPrefix.length()) {
            return false;
        }

        String prefix = url.substring(0, expectedPrefix.length());
        return prefix.equals(expectedPrefix);
    }

    @Override
    public LinkDTO newLink(Link link) {
        if (isUrlValid(link.getUrl()) == false) {
            throw new BadRequestException("La url introducida no es válida.");
        }

        if (linkTrackerRepository.isLinkPresent(link)) {
            throw new EntryAlreadyExistsException("El link que se intenta agregar ya existe.");
        }

        linkTrackerRepository.newLink(link);
        return LinkDTO.linkToDTO(link);
    }

    @Override
    public String getRedirection(Integer linkId) {
        Link link = linkTrackerRepository.findLinkById(linkId);
        if (link == null) {
            throw new NotFoundException("No hay URLs con id " + linkId + " en nuestros registros.");
        } else if (!link.getIsValid()) {
            throw new InvalidLinkException("La URL solicitada ha sido invalidada.");
        }
        linkTrackerRepository.addRedirection(linkId);
        return link.getUrl();
    }

    @Override
    public Integer getNumberOfRedirections(Integer linkID) {
        Integer result = linkTrackerRepository.getNumbreOfRedirections(linkID);
        if (result == null) {
            throw new NotFoundException("No se encontró link con id " + linkID);
        }
        return result;
    }

    @Override
    public String invalidateLink(Integer linkID) {
        Boolean result = linkTrackerRepository.invalidateLink(linkID);
        if (result == false) {
            throw new NotFoundException("No se encontró una URL con Id " + linkID);
        }
        return "La URL fue invalidada con éxito.";
    }
}
