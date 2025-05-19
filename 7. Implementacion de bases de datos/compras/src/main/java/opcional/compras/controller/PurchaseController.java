package opcional.compras.controller;

import opcional.compras.dto.PurchaseDto;
import opcional.compras.service.IPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private IPurchaseService purchaseService;

    @GetMapping("/all")
    public ResponseEntity<List<PurchaseDto>> getAllPurchases() {
        return new ResponseEntity<>(purchaseService.getAllPurchases(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PurchaseDto> addPurchase(@RequestBody PurchaseDto body) {
        return new ResponseEntity<>(purchaseService.addPurchase(body), HttpStatus.OK);
    }

}
