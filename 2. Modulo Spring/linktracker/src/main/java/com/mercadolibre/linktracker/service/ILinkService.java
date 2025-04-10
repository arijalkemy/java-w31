package com.mercadolibre.linktracker.service;

import com.mercadolibre.linktracker.dto.LinkDTO;
import com.mercadolibre.linktracker.dto.LinkStatsDTO;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface ILinkService {
    Integer createLink(String url, String password);
    LinkDTO handleRedirect(Integer id, String password);
    public LinkStatsDTO  getMetrics(Integer id);
    void invalidateLink(Integer id, String password);
}
