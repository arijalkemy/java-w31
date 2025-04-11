package com.mercadolibre.modulospring.linktracker.service;

import com.mercadolibre.modulospring.linktracker.dto.LinkDTO;
import com.mercadolibre.modulospring.linktracker.dto.ResponseLinkDTO;
import com.mercadolibre.modulospring.linktracker.entity.Link;
import com.mercadolibre.modulospring.linktracker.exception.IsNotValidExcep;
import com.mercadolibre.modulospring.linktracker.exception.NotFoundException;
import com.mercadolibre.modulospring.linktracker.repository.LinkRepositoryIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceIMP implements ILinkService{
    @Autowired
    LinkRepositoryIMP linkRepositoryIMP;
    @Override
    public ResponseLinkDTO addLink(LinkDTO linkDTO) {

        Link link=new Link(linkDTO.getId(), linkDTO.getLink(), linkDTO.getPassword(), true,0);
        linkRepositoryIMP.addLink(link);

        return new ResponseLinkDTO(link.getId(),link.getLink());
    }

    @Override
    public String getLink(Integer id,String password) {
        Link link=linkRepositoryIMP.getLink(id);
        if(link!=null){
            if(link.getValid().equals(true)&& link.getPassword().equals(password)) {
                link.setNumVisited(link.getNumVisited() + 1);
                return link.getLink();
            }else{
                throw new IsNotValidExcep("LINK INAVILITADO O INVALIDO");

            }
        }else{
            throw new NotFoundException("INVESTIGAR REDIRECT");

        }
    }

    @Override
    public Integer getMetrics(Integer id) {
        Link link= linkRepositoryIMP.getLink(id);
        if(link!=null){
            return link.getNumVisited();
        }else{
            throw new NotFoundException("INVESTIGAR REDIRECT");

        }

    }

    @Override
    public String invalidLink(Integer id) {
        if(linkRepositoryIMP.invalidlink(id)){
            return "Link invalidado";
        }
        throw new NotFoundException("INVESTIGAR REDIRECT");
    }
}
