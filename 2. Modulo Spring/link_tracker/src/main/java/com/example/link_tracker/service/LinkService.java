package com.example.link_tracker.service;

import com.example.link_tracker.dto.LinkRequestDto;
import com.example.link_tracker.dto.LinkResponseDto;
import com.example.link_tracker.entity.Link;
import com.example.link_tracker.exception.NotFoundException;
import com.example.link_tracker.exception.UnauthorizedAccessException;
import com.example.link_tracker.repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class LinkService implements ILinkService{

    private ILinkRepository iLinkRepository;

    @Override
    public LinkResponseDto createLink(LinkRequestDto linkRequest) {

        String linkId = Integer.toHexString(linkRequest.getUrl().hashCode());
        Link link = new Link(linkId, linkRequest.getUrl(), linkRequest.getPassword(), 0);

        link = iLinkRepository.save(link);

        return new LinkResponseDto(link.getId(), link.getUrl(), link.getRedirectionCount());
    }

    @Override
    public String redirectLink(String linkId, String password) {

        Link link = iLinkRepository.findByLinkId(linkId);

        if (link == null) {
            throw new NotFoundException("Link not found");
        }

        if (password != null && !password.equals(link.getPassword())) {
            throw new UnauthorizedAccessException("Incorrect password");
        }

        link.setRedirectionCount(link.getRedirectionCount() + 1);
        iLinkRepository.save(link);

        return link.getUrl();
    }

    @Override
    public int getRedirectionCount(String linkId) {

        Link link = iLinkRepository.findByLinkId(linkId);

        if (link == null) {
            throw new NotFoundException("Link not found");
        }

        return link.getRedirectionCount();
    }

    @Override
    public void invalidateLink(String linkId) {

        Link link = iLinkRepository.findByLinkId(linkId);

        if (link == null) {
            throw new NotFoundException("Link not found");
        }

        iLinkRepository.delete(linkId);
    }


}
