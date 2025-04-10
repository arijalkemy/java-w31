package com.linktracker.linktracker.service;

import com.linktracker.linktracker.dto.LinkDTO;
import com.linktracker.linktracker.exception.LinkNoValido;
import com.linktracker.linktracker.exception.PasswordIncorrecto;
import com.linktracker.linktracker.mapper.IMapper;
import com.linktracker.linktracker.mapper.MapperImpl;
import com.linktracker.linktracker.model.Link;
import com.linktracker.linktracker.repository.ILinkRepository;
import com.linktracker.linktracker.repository.LinkRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class LinkServiceImpl implements ILinkService {

    private final AtomicInteger idGenerador = new AtomicInteger(0);

    @Autowired
    ILinkRepository repository;

    @Autowired
    IMapper mapper;

    @Override
    public LinkDTO createLink(String url, String password) {
        Integer id = idGenerador.incrementAndGet();
        LinkDTO linkDTO = new LinkDTO(url,password);
        linkDTO.setId(id);
        repository.save(linkDTO);

        return linkDTO;
    }

    @Override
    public String getRedirectUrl(int id, String password) {
        Link link = repository.findById(id);
        //Mapear
        LinkDTO linkDTO = mapper.linkTOLinkDTO(link);

        //Pregunto que sea valido
        if(!linkDTO.getValid()){
            throw new LinkNoValido("Link no valido");
        }
        //Pregunto por el pass
        if(linkDTO.getPassword() != null){
            if(!linkDTO.getPassword().equals(password)){
                throw new PasswordIncorrecto("El password ingresado no coincide");
            }
        }

        linkDTO.incrementRedirectCount();
        repository.save(linkDTO);

        //retorno
        return linkDTO.getUrl();
    }

    @Override
    public Integer getRedirectCount(int id) {
        return mapper.linkTOLinkDTO(repository.findById(id)).getRedirectCount();
    }

    @Override
    public void invalidateLink(int id) {
        repository.findById(id).setValid(false);
    }

}
