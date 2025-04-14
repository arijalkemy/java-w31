package com.mercadolibre.linktracker.service;

import com.mercadolibre.linktracker.dto.LinkDto;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URISyntaxException;


public interface ILinkService {
    LinkDto save(LinkDto linkDto) throws MalformedURLException, URISyntaxException;
    LinkDto findById(Long id);
    HttpHeaders redirectLink(Long id);
    LinkDto metrics(Long id);
}
