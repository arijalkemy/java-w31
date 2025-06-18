package com.mercadolibre.melifrescosg9w31.service;

import com.mercadolibre.melifrescosg9w31.dtos.response.BatchResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface IBatchService {
    BatchResponseDTO getExpiringBatches(Integer days, String category, String order);
}
