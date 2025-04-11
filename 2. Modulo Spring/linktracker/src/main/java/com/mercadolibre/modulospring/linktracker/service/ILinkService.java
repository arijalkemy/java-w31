package com.mercadolibre.modulospring.linktracker.service;

import com.mercadolibre.modulospring.linktracker.dto.LinkDTO;
import com.mercadolibre.modulospring.linktracker.dto.ResponseLinkDTO;

public interface ILinkService {
    ResponseLinkDTO addLink(LinkDTO linkDTO);
    String getLink(Integer id,String password);
    Integer getMetrics(Integer id);
    String invalidLink(Integer id);
}
