package com.mercadolibre.modulospring.linktracker.repository;


import com.mercadolibre.modulospring.linktracker.entity.Link;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
@Getter
public class LinkRepositoryIMP implements ILinkRepository{
    private List<Link> links=new ArrayList<>();


    @Override
    public void addLink(Link link) {
        links.add(link);
    }

    @Override
    public Link getLink(Integer id) {
        return links.stream().filter(l->l.getId().equals(id)).findFirst().orElse(null);


    }

    @Override
    public Boolean invalidlink(Integer id) {
        Link link= this.getLink(id);
        if(link!=null){
            link.setValid(false);
            return true;
        }
        return false;
    }


}
