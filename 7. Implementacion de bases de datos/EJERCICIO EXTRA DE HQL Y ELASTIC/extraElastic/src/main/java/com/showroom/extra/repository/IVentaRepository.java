package com.showroom.extra.repository;

import com.showroom.extra.model.Prenda;
import com.showroom.extra.model.Venta;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import java.time.LocalDate;
import java.util.List;

public interface IVentaRepository extends ElasticsearchRepository<Venta, String> {
    List<Venta> findAllByFecha(LocalDate date);

    List<Venta> findAll();
}
