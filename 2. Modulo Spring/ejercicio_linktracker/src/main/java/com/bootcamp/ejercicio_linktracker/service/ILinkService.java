package com.bootcamp.ejercicio_linktracker.service;

import com.bootcamp.ejercicio_linktracker.dto.CreateLinkDto;

public interface ILinkService {
    Integer getVisitCount(Integer linkId);
    Integer saveLink(CreateLinkDto createLinkDto);

    String getRedirect(Integer linkId, String password);

    void invalidateLink(Integer linkId);
}
