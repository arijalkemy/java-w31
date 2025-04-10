package com.mercadolibre.linktracker.service;

import com.mercadolibre.linktracker.dto.LinkDto;
import org.springframework.stereotype.Service;


public interface ILinkService {
    Long save(LinkDto linkDto);


}
