package com.mercadolibre.hql.service;

import com.mercadolibre.hql.dto.EpisodeDto;

import java.util.List;

public interface IEpisodeService {
    public List<EpisodeDto> getEpisodesByActorId(Integer actorId);
}
