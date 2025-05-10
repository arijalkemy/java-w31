package com.mercadolibre.linktracker.service;

import com.mercadolibre.linktracker.dto.LinkRequestDto;
import com.mercadolibre.linktracker.dto.LinkResponseDto;
import com.mercadolibre.linktracker.entity.Link;
import com.mercadolibre.linktracker.exception.LinkNotFoundException;
import com.mercadolibre.linktracker.exception.UnauthorizedAccessException;
import com.mercadolibre.linktracker.repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkService implements ILinkService {

    @Autowired
    private ILinkRepository linkRepository;

    @Override
    public LinkResponseDto createLink(LinkRequestDto linkRequest) {

        String linkId = Integer.toHexString(linkRequest.getUrl().hashCode());
        Link link = new Link(linkId, linkRequest.getUrl(), linkRequest.getPassword(), 0);

        link = linkRepository.save(link);

        return new LinkResponseDto(link.getLinkId(), link.getUrl(), link.getRedirectionCount());
    }

    @Override
    public String redirectLink(String linkId, String password) {

        Link link = linkRepository.findByLinkId(linkId);

        if (link == null) {
            throw new LinkNotFoundException("Link not found");
        }

        if (password != null && !password.equals(link.getPassword())) {
            throw new UnauthorizedAccessException("Incorrect password");
        }

        link.setRedirectionCount(link.getRedirectionCount() + 1);
        linkRepository.save(link);

        return link.getUrl();
    }

    @Override
    public int getRedirectionCount(String linkId) {

        Link link = linkRepository.findByLinkId(linkId);

        if (link == null) {
            throw new LinkNotFoundException("Link not found");
        }

        return link.getRedirectionCount();
    }

    @Override
    public void invalidateLink(String linkId) {

        Link link = linkRepository.findByLinkId(linkId);

        if (link == null) {
            throw new LinkNotFoundException("Link not found");
        }

        linkRepository.delete(linkId);
    }

}