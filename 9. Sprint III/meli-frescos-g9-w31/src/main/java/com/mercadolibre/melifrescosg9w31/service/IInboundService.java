package com.mercadolibre.melifrescosg9w31.service;

import com.mercadolibre.melifrescosg9w31.dtos.request.InboundOrderRequest;
import com.mercadolibre.melifrescosg9w31.dtos.response.ResponseBatchStockWrapperDTO;
import jakarta.transaction.Transactional;

public interface IInboundService {
    ResponseBatchStockWrapperDTO newInboundOrder(
            InboundOrderRequest request, Long authenticatedRepId);

    @Transactional
    ResponseBatchStockWrapperDTO updateInboundOrder(
            InboundOrderRequest inboundOrderRequest, Long authenticatedRepId);
}
