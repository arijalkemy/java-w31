package co.com.mercadolibre.joyerialasperlas.repository;

import co.com.mercadolibre.joyerialasperlas.model.Jewelry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJewelryRepository extends JpaRepository<Jewelry, Long> {

    List<Jewelry> findAllByVentaONoIsTrue();
}
