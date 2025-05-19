package opcional.compras.service;

import opcional.compras.dto.PurchaseDto;

import java.util.List;

public interface IPurchaseService {
    PurchaseDto addPurchase(PurchaseDto purchaseDto);
    List<PurchaseDto> getAllPurchases();
}
