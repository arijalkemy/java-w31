package siniestros.vehiculos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import siniestros.vehiculos.dto.InsuranceClaimDto;
import siniestros.vehiculos.service.IInsuranceClaimService;

import java.util.List;

@RestController
@RequestMapping("/insurance-claim")
public class InsuranceClaimController {

    @Autowired
    private IInsuranceClaimService insuranceClaimInService;

    @GetMapping
    public ResponseEntity<List<InsuranceClaimDto>> findAll() {
        return new ResponseEntity<>(insuranceClaimInService.findAll(), HttpStatus.OK);
    }
}
