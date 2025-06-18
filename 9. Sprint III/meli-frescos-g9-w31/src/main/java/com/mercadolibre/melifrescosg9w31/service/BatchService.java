package com.mercadolibre.melifrescosg9w31.service;

import com.mercadolibre.melifrescosg9w31.dtos.response.BatchItemResponseDTO;
import com.mercadolibre.melifrescosg9w31.dtos.response.BatchResponseDTO;
import com.mercadolibre.melifrescosg9w31.exceptions.BadRequestException;
import com.mercadolibre.melifrescosg9w31.exceptions.NotFoundException;
import com.mercadolibre.melifrescosg9w31.mapper.BatchMapper;
import com.mercadolibre.melifrescosg9w31.repository.IBatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BatchService implements IBatchService {

    private final IBatchRepository batchRepository;

    @Override
    public BatchResponseDTO getExpiringBatches(Integer days, String category, String order) {
        LocalDate today = LocalDate.now();
        LocalDate futureDate = today.plusDays(days);
        List<BatchItemResponseDTO> batchesDto;
        if ((Objects.nonNull(order) || Objects.nonNull(category)) && (Objects.isNull(order) || Objects.isNull(category))) {
            throw new BadRequestException("Both filter values must be provided.");
        }
        if (Objects.isNull(category)) {
            batchesDto = batchRepository.findBatchesWithDueDateBetweenOrderedAsc(today, futureDate).stream().map(BatchMapper::toBatchItemResponseDTO).toList();
        } else {
            switch (order) {
                case "date_asc" -> batchesDto = batchRepository.findBatchesWithDueDateBetweenFromCategoryOrderedAsc(today, futureDate, category).stream().map(BatchMapper::toBatchItemResponseDTO).toList();
                case "date_desc" -> batchesDto = batchRepository.findBatchesWithDueDateBetweenFromCategoryOrderedDesc(today, futureDate, category).stream().map(BatchMapper::toBatchItemResponseDTO).toList();
                default -> throw new BadRequestException("Order not valid.");
            }
        }
        if (batchesDto.isEmpty()) {
            throw new NotFoundException("There are no batches that expire in that time.");
        }
        return new BatchResponseDTO(batchesDto);
    }
}
