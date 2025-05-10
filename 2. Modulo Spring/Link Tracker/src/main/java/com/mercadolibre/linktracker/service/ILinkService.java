package com.mercadolibre.linktracker.service;

import com.mercadolibre.linktracker.dto.LinkRequestDto;
import com.mercadolibre.linktracker.dto.LinkResponseDto;

public interface ILinkService {

    LinkResponseDto createLink(LinkRequestDto linkRequest);

    String redirectLink(String linkId, String password);

    int getRedirectionCount(String linkId);

    void invalidateLink(String linkId);
}
