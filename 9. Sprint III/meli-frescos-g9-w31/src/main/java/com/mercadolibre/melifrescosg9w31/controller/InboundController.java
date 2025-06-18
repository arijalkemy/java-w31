package com.mercadolibre.melifrescosg9w31.controller;

import com.mercadolibre.melifrescosg9w31.dtos.request.InboundOrderRequestWrapperDTO;
import com.mercadolibre.melifrescosg9w31.dtos.response.ResponseBatchStockWrapperDTO;
import com.mercadolibre.melifrescosg9w31.entity.UserAccount;
import com.mercadolibre.melifrescosg9w31.service.IInboundService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fresh-products/inboundorder")
@RequiredArgsConstructor
public class InboundController {

    private final IInboundService inboundService;

    @PostMapping
    public ResponseEntity<ResponseBatchStockWrapperDTO> newInboundOrder(
            @Valid @RequestBody InboundOrderRequestWrapperDTO inboundOrderRequest
    ) {
        return ResponseEntity.ok()
                .body(
                        inboundService.newInboundOrder(
                                inboundOrderRequest.getInboundOrder(), getAuthenticatedRepId()));
    }

    private Long getAuthenticatedRepId() {
        UserAccount userAccount = getLoggedUser();
        return userAccount.getId();
    }

    public UserAccount getLoggedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserAccount) {
            return (UserAccount) authentication.getPrincipal();
        }
        return null;
    }


    @PutMapping
    ResponseEntity<ResponseBatchStockWrapperDTO> updateInboundOrder(@Valid @RequestBody InboundOrderRequestWrapperDTO inboundOrder) {
        return new ResponseEntity<>(inboundService.updateInboundOrder(inboundOrder.getInboundOrder(), getAuthenticatedRepId()), HttpStatus.CREATED);
    }
}
