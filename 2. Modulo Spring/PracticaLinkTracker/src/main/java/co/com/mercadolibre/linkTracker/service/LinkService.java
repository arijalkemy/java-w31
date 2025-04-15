package co.com.mercadolibre.linkTracker.service;

import org.springframework.http.HttpHeaders;

import co.com.mercadolibre.linkTracker.dto.LinkDto;

public interface LinkService {

    LinkDto save(LinkDto linkDto);
    LinkDto getById (Long id);
    HttpHeaders redirect (Long id);
    LinkDto getMetricsById (Long id);
    void invalidateLink(Long id, LinkDto linkDto);
}
