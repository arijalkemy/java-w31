package com.example.link_tracker.service;

import com.example.link_tracker.dto.LinkRequestDto;
import com.example.link_tracker.dto.LinkResponseDto;

public interface ILinkService {
    LinkResponseDto createLink(LinkRequestDto linkRequest);

    String redirectLink(String linkId, String password);

    int getRedirectionCount(String linkId);

    void invalidateLink(String linkId);
}
