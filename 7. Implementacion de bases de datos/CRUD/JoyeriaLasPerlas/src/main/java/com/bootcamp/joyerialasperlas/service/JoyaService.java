package com.bootcamp.joyerialasperlas.service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.bootcamp.joyerialasperlas.dto.JoyaDto;
import com.bootcamp.joyerialasperlas.exception.BadRequestException;
import com.bootcamp.joyerialasperlas.exception.JoyaNotFoundException;
import com.bootcamp.joyerialasperlas.model.Joya;
import com.bootcamp.joyerialasperlas.repository.IJoyaRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class JoyaService implements IJoyaService {
    private final IJoyaRepository repository;
    public JoyaService(IJoyaRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true) 
    public List<JoyaDto> getJoyas() {
        List<Joya> joyas = repository.findAll();
        if (joyas.isEmpty()) {
            throw new JoyaNotFoundException("No se encontraron joyas.");
        }

        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(joyas, new TypeReference<List<JoyaDto>>() {});
    }

    @Override
    @Transactional
    public Long saveJoya(JoyaDto joyaDto) {
        if (Boolean.FALSE.equals(joyaDto.getVentaONo())) {
            throw new BadRequestException("Al crear una joya el campo 'ventaONo' debe ser verdadero");
        }

        ObjectMapper mapper = new ObjectMapper();
        Joya joya = mapper.convertValue(joyaDto, Joya.class);

        repository.save(joya);
        return joya.getId();
    }

    @Override
    @Transactional
    public void deleteJoya(Long idJoya) {
        Joya joya = repository.findById(idJoya).orElse(null);
        if (joya == null) {
            throw new JoyaNotFoundException("No se encontró una joya de id " + idJoya);
        }

        if (Boolean.TRUE.equals(joya.getVentaONo())) {
            throw new BadRequestException("Al eliminar una joya el campo 'ventaONo' debe ser falso");
        }

        repository.deleteById(idJoya);
    }

    @Override
    @Transactional(readOnly = true) 
    public JoyaDto findJoya(Long idJoya) {
        Joya joya = repository.findById(idJoya).orElse(null);
        if (joya == null) {
            throw new JoyaNotFoundException("No se encontró una joya de id " + idJoya);
        }
        return JoyaDto.joyaToDto(joya);
    }

    @Override
    @Transactional
    public JoyaDto updateJoya(Long idModificar, JoyaDto joyaDto) {
        Joya joya = repository.findById(idModificar).orElse(null);
        if (joya == null) {
            throw new JoyaNotFoundException("No se encontró una joya de id " + idModificar);
        }

        joya.setNombre(joyaDto.getNombre());
        joya.setMaterial(joyaDto.getMaterial());
        joya.setPeso(joyaDto.getPeso());
        joya.setParticularidad(joyaDto.getParticularidad());
        joya.setPoseePiedra(joyaDto.getPoseePiedra());
        joya.setVentaONo(joyaDto.getVentaONo());
        repository.save(joya);

        joyaDto.setId(idModificar);
        return joyaDto;
    }

}
