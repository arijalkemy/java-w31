package com.mercadolibre.linktracker.service;

import com.mercadolibre.linktracker.dto.LinkTrackerDTO;
import com.mercadolibre.linktracker.dto.LinkTrackerStatsDTO;

public interface ILinkTrackerService {

    Integer createUrl(String url, String password);
    LinkTrackerDTO redirectLink(Integer id, String password);
    LinkTrackerStatsDTO getUrlMetrics(Integer id);
    LinkTrackerDTO invalidateUrl(Integer id, String password);

}
