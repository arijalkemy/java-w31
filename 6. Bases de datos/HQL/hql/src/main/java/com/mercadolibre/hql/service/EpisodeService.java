package com.mercadolibre.hql.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.hql.dto.EpisodeDto;
import com.mercadolibre.hql.repository.IEpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpisodeService implements IEpisodeService{
    @Autowired
    IEpisodeRepository episodeRepository;

    public List<EpisodeDto> getEpisodesByActorId(Integer actorId) {
        ObjectMapper mapper = new ObjectMapper();
        return episodeRepository.findEpisodesByActorId(actorId).stream()
                .map(e -> mapper.convertValue(e, EpisodeDto.class)).toList();
    }

}
