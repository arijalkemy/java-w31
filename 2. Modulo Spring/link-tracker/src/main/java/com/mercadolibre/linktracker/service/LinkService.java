package com.mercadolibre.linktracker.service;

import com.mercadolibre.linktracker.dto.LinkDto;
import com.mercadolibre.linktracker.dto.LinkMapper;
import com.mercadolibre.linktracker.entity.Link;
import com.mercadolibre.linktracker.exception.NotFoundException;
import com.mercadolibre.linktracker.repository.ILinkRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;
import java.util.Optional;

@Service
public class LinkService implements ILinkService {

    private final ILinkRepository linkRepository;

    public LinkService(ILinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public LinkDto save(LinkDto linkDto) {
        Optional<Link> linkSaved = linkRepository.findByUrl(linkDto.getUrl());

        if (linkSaved.isPresent()){
            throw new RuntimeException("Url Already Exists");
        }

        if (!isValidURL(linkDto.getUrl())){
            throw new RuntimeException("URL NO VALDA");
        }

        Long idSaved = linkRepository.save(LinkMapper.linkDtoToLink(linkDto));
        LinkDto linkSave = new LinkDto();
        linkSave.setId(idSaved);
        return linkSave;
    }

    public HttpHeaders redirectLink(Long id) {
        LinkDto url = findById(id);
        linkRepository.redirectLink(id);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(url.getUrl()));

        return headers;
    }

    @Override
    public LinkDto findById(Long id) {
        Optional<Link> link = linkRepository.findById(id);

        if (link.isEmpty()){
            throw new NotFoundException("Not found Url with this Id");
        }
        System.out.println("Service: " + link);

        return LinkMapper.linkToLinkDto(link.get());
    }

    @Override
    public LinkDto metrics(Long id) {
        return findById(id);
    }

    boolean isValidURL(String url)  {
        try {
            new URL(url).toURI();
            return true;
        } catch (MalformedURLException | URISyntaxException e) {
            return false;
        }
    }


}
