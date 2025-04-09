package com.bootcamp.linktracker.service;

import com.bootcamp.linktracker.dto.LinkDto;

public interface ILinkService {
    LinkDto create(LinkDto linkDto);
    LinkDto getById(Integer id);
    LinkDto getByIdToUpdate(Integer id, String password);
    LinkDto getMetrics(Integer id);
    Boolean removeById(Integer id, String password);
}
