package com.mercadolibre.elasticsearch.service;

import com.mercadolibre.elasticsearch.dto.EmpleadoDto;
import com.mercadolibre.elasticsearch.model.Empleado;
import org.springframework.stereotype.Service;

@Service
public interface IEmpleadoService {
    Empleado save(EmpleadoDto empleado);
}
