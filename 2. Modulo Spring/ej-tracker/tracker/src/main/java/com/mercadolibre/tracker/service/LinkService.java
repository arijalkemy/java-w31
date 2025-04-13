package com.mercadolibre.tracker.service;

import com.mercadolibre.tracker.dto.RequestLinkDto;
import com.mercadolibre.tracker.dto.ResponseLinkDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface LinkService {
    ResponseLinkDto createLink(RequestLinkDto requestLink);

    String redirect(String linkId, String password);

    Integer getMetrics(String linkId);

    String invalidate(String linkId);
}
