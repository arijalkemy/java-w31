package com.mercadolibre.bootcamp.linktracker.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.bootcamp.linktracker.dto.LinkDto;
import com.mercadolibre.bootcamp.linktracker.dto.MetricsDto;
import com.mercadolibre.bootcamp.linktracker.exceptions.NotFoundException;
import com.mercadolibre.bootcamp.linktracker.model.Link;
import com.mercadolibre.bootcamp.linktracker.repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LinkServiceImpl implements ILinkService{

    private ILinkRepository linkRepository;

    @Autowired
    public LinkServiceImpl(ILinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public List<LinkDto> findAll(){
        ObjectMapper objectMapper = new ObjectMapper();
        List<Link> links = linkRepository.findAll();
        return links.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public LinkDto save(LinkDto linkDto){
        Link link = linkRepository.save(convertToEntity(linkDto));
        return convertToDto(link);
    }

    @Override
    public String redirectsUrl(Long id){
        Link link = linkRepository.findById(id);
        if(link == null){
            throw new NotFoundException("No se encontró el link");
        }
        if(link.getValid()){
            System.out.println("Redirect sin param");
            link.call();
            return link.getUrl();
        }else {
            throw new NotFoundException("Link invalido");
        }
    }


    @Override
    public String redirectsUrl(Long id, String password){
        Link link = linkRepository.findById(id);
        if(link == null){
            throw new NotFoundException("No se encontró el link");
        }
        if(link.getValid() && link.getPassword().equals(password)){
            System.out.println("Redirect con param");
            link.call();
            return link.getUrl();
        }else {
            throw new NotFoundException("Link invalido o contraseña errada");
        }
    }

    @Override
    public MetricsDto getLinkMetrics(Long id){
        Link link = linkRepository.findById(id);
        if(link == null){
            throw new NotFoundException("No se encontró el link");
        }
        return new MetricsDto(link.getUrl(), link.getRedirects());

    }

    @Override
    public LinkDto invalidateLink(Long linkID) {
        Link link = linkRepository.findById(linkID);
        if(link == null){
            throw new NotFoundException("No se encontró el link");
        }
        link.setValid(Boolean.FALSE);
        return convertToDto(link);

    }

    public LinkDto convertToDto(Link link) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(link, LinkDto.class);
    }

    public Link convertToEntity(LinkDto linkDto){
        ObjectMapper mapper =  new ObjectMapper();
        return mapper.convertValue(linkDto, Link.class);
    }
}
