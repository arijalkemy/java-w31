package com.mercadolibre.elasticsearch.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.elasticsearch.dto.EmpleadoDto;
import com.mercadolibre.elasticsearch.model.Empleado;
import com.mercadolibre.elasticsearch.repository.IEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService implements IEmpleadoService {

    @Autowired
    IEmpleadoRepository empleadoRepository;


    @Override
    public Empleado save(EmpleadoDto empleado) {
        ObjectMapper mapper = new ObjectMapper();
        Empleado parsedEmpleado = mapper.convertValue(empleado, Empleado.class);
        return empleadoRepository.save(parsedEmpleado);
    }
}
