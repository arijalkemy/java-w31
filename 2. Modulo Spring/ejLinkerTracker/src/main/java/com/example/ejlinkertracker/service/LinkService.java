package com.example.ejlinkertracker.service;

import com.example.ejlinkertracker.dto.LinkDtoRequest;
import com.example.ejlinkertracker.dto.LinkIdResponseDto;
import com.example.ejlinkertracker.dto.MetricResponseDto;
import com.example.ejlinkertracker.exception.InstanceAlreadyExistsException;
import com.example.ejlinkertracker.exception.NotFoundException;
import com.example.ejlinkertracker.repository.ILinkRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ejlinkertracker.model.LinkTacker;


import java.util.List;

@Service
public class LinkService implements ILinkService{
    @Autowired
    ILinkRepository linkRepository;

    @Override
    public List<LinkDtoRequest> searchAll() {
        List<LinkTacker> linkTackers = linkRepository.findAll();
        ObjectMapper mapper = new ObjectMapper();
        List<LinkDtoRequest>  linkDtoRequests = linkTackers.stream()
                .map(l -> mapper.convertValue(l, LinkDtoRequest.class))
                .toList();

        if(linkDtoRequests.isEmpty()){
            throw new NotFoundException("No hay links disponibles");
        }
        return linkDtoRequests;
    }

    @Override
    public LinkIdResponseDto addLink(LinkDtoRequest link) {
        List<LinkTacker> linkList = linkRepository.findAll();
        ObjectMapper mapper = new ObjectMapper();
        if(findedId(link.getId())){
            throw new InstanceAlreadyExistsException("Ya se encuentra un link con este id");
        }
        link.setNumOfRedir(0);
        link.setIsValid(true);
        linkList.add(mapper.convertValue(link, LinkTacker.class));
        return new LinkIdResponseDto(link.getId());
    }

    @Override
    public String redirect(Long linkId) {
        List<LinkTacker> linkTackers = linkRepository.findAll();
        for(LinkTacker link : linkTackers){
            if(link.getId().equals(linkId)){
                Integer redir = link.getNumOfRedir();
                redir++;
                link.setNumOfRedir(redir);
                return "Redireccion exitosa";
            }
        }
        throw new NotFoundException("No existe el link de redireccion");
    }

    @Override
    public MetricResponseDto metrics(Long linkId) {
        List<LinkTacker> linkTackers = linkRepository.findAll();
        if(!findedId(linkId)){
            throw new NotFoundException("No existe el link");
        }
        for(LinkTacker linkTacker : linkTackers){
            if(linkTacker.getId().equals(linkId)){
                return new MetricResponseDto("La cantidad de redirecciones del link es: " + linkTacker.getNumOfRedir());
            }
        }

        throw new NotFoundException("No hay links");
    }

    @Override
    public String invalidate(Long linkId) {
        List<LinkTacker> linkTackers = linkRepository.findAll();
        for(LinkTacker linkTacker : linkTackers){
            if(linkTacker.getId().equals(linkId)){
                linkTacker.setIsValid(false);
                return "Se invalido correctamente el link";
            }
        }
        throw new NotFoundException("No se encontro el link a invalidar");
    }

    private boolean findedId(Long id){
        List<LinkTacker> linkList = linkRepository.findAll();
        for(LinkTacker link : linkList){
            if (link.getId().equals(id)){
                return true;
            }
        }
        return false;
    }
}
