package siniestros.vehiculos.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import siniestros.vehiculos.dto.InsuranceClaimDto;
import siniestros.vehiculos.dto.VehicleDto;
import siniestros.vehiculos.model.InsuranceClaim;
import siniestros.vehiculos.model.Vehicle;
import siniestros.vehiculos.repository.IInsuranceClaimRepository;
import siniestros.vehiculos.repository.IVehicleRepository;
import siniestros.vehiculos.service.IInsuranceClaimService;

import java.util.List;

@Service
public class InsuranceClaimServiceServiceImpl implements IInsuranceClaimService {

    @Autowired
    private IInsuranceClaimRepository insuranceClaimRepository;

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public List<InsuranceClaimDto> findAll() {
        List<InsuranceClaim> result = insuranceClaimRepository.findAll();
        return result.stream()
                .map(v -> mapper.convertValue(v, InsuranceClaimDto.class))
                .toList();
    }
}
