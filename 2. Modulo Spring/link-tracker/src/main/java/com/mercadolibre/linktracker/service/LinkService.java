package com.mercadolibre.linktracker.service;

import com.mercadolibre.linktracker.dto.LinkDto;
import com.mercadolibre.linktracker.dto.LinkMapper;
import com.mercadolibre.linktracker.entity.Link;
import com.mercadolibre.linktracker.repository.ILinkRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LinkService implements ILinkService{

    private final ILinkRepository linkRepository;

    public LinkService(ILinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public Long save(LinkDto linkDto) {
        Link linkSave = LinkMapper.linkDtoToLink(linkDto);
        return linkRepository.save(linkSave);
    }

    public void redirectLink(Long id){
        Link link = linkRepository.findById(id);

        if (Objects.isNull(link)){
            throw new RuntimeException("Not Found");
        }

        link.incrementRedirect();

        // Set mensaje de redirect  ...
        String url = link.getUrl();

    }
}
