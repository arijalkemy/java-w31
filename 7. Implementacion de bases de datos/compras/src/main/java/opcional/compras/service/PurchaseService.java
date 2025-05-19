package opcional.compras.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import opcional.compras.dto.PurchaseDto;
import opcional.compras.model.Purchase;
import opcional.compras.repository.IPurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService implements IPurchaseService {

    @Autowired
    private IPurchaseRepository purchaseRepository;

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public PurchaseDto addPurchase(PurchaseDto purchaseDto) {
        Purchase purchase = mapper.convertValue(purchaseDto, Purchase.class);
        Purchase inserted = purchaseRepository.save(purchase);
        return mapper.convertValue(inserted, PurchaseDto.class);
    }

    @Override
    public List<PurchaseDto> getAllPurchases() {
        List<Purchase> purchases = purchaseRepository.findAll();
        return purchases.stream()
                .map(p -> mapper.convertValue(p, PurchaseDto.class))
                .toList();
    }
}
