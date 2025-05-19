package siniestros.vehiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import siniestros.vehiculos.model.InsuranceClaim;

public interface IInsuranceClaimRepository extends JpaRepository<InsuranceClaim, Long> {
}
