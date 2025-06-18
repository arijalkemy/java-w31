package com.mercadolibre.melifrescosg9w31.repository;

import com.mercadolibre.melifrescosg9w31.entity.InboundOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IInboundOrderRepository extends JpaRepository<InboundOrder, Long> {
    Optional<InboundOrder> findInboundOrderByOrderNumber(Integer orderNumber);
}
