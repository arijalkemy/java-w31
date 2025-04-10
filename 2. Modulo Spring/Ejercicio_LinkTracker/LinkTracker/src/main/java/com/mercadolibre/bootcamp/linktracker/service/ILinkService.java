package com.mercadolibre.bootcamp.linktracker.service;

import com.mercadolibre.bootcamp.linktracker.dto.LinkDto;
import com.mercadolibre.bootcamp.linktracker.dto.MetricsDto;

import java.util.List;

public interface ILinkService {
    List<LinkDto> findAll();

    LinkDto save(LinkDto linkDto);

    String redirectsUrl(Long id);

    String redirectsUrl(Long id, String password);

    MetricsDto getLinkMetrics(Long id);

    LinkDto invalidateLink(Long linkID);
}
