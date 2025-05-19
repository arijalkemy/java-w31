package siniestros.vehiculos.service;

import siniestros.vehiculos.dto.InsuranceClaimDto;

import java.util.List;

public interface IInsuranceClaimService {
    List<InsuranceClaimDto> findAll();
}
