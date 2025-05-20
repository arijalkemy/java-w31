package org.mercadolibre.ejercicio_empleados.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.mercadolibre.ejercicio_empleados.dto.EmpleadoDTO;
import org.mercadolibre.ejercicio_empleados.entities.Empleado;
import org.mercadolibre.ejercicio_empleados.repository.EmpleadoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{

    final private EmpleadoRepository repository;
    ObjectMapper mapper = new ObjectMapper();

    public EmpleadoServiceImpl(EmpleadoRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmpleadoDTO createEmployee(EmpleadoDTO empleado) {

        Empleado employee = mapper.convertValue(empleado, Empleado.class);

        repository.save(employee);
        return empleado;
    }

    @Override
    public List<EmpleadoDTO> getAllEmployees() {

        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(empleado -> mapper.convertValue(empleado, EmpleadoDTO.class))
                .collect(Collectors.toList());
    }
}
