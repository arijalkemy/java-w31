package com.bootcamp.linktracker.service;

import com.bootcamp.linktracker.dto.LinkDto;
import com.bootcamp.linktracker.model.Link;
import com.bootcamp.linktracker.repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImpl implements ILinkService {
    @Autowired
    ILinkRepository linkRepository;

    @Override
    public LinkDto create(LinkDto linkDto) {
        Link link = linkRepository.add(Link.buildFromDto(linkDto)) ;
        return new LinkDto(link.getId(), null, null, null);
    }

    @Override
    public LinkDto getById(Integer id) {
        return LinkDto.buildFromLink(linkRepository.getById(id));
    }

    @Override
    public LinkDto getByIdToUpdate(Integer id, String password) {
        Link link = linkRepository.getById(id);
        if (link.getPassword().equals(password)) {
            return LinkDto.buildFromLink(linkRepository.update(id));
        }
        return null;
    }

    @Override
    public LinkDto getMetrics(Integer id) {
        Link link = linkRepository.getById(id);
        return new LinkDto(link.getId(), link.getUrl(), link.getTimesRedirected(), null);
    }

    @Override
    public Boolean removeById(Integer id, String password) {
        Link link = linkRepository.getById(id);
        if (link != null && link.getPassword().equals(password)) {
            return linkRepository.removeById(id);
        }
        return false;
    }
}
