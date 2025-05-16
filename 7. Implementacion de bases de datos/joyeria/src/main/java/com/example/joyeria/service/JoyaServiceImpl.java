package com.example.joyeria.service;

import com.example.joyeria.DTO.JoyaDTO;
import com.example.joyeria.entity.Joya;
import com.example.joyeria.exceptions.NotFoundException;
import com.example.joyeria.repository.RepositoryJoyas;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoyaServiceImpl implements JoyaServie{

    private final RepositoryJoyas repositoryJoyas;
    private ObjectMapper mapper = new ObjectMapper();

    public JoyaServiceImpl(RepositoryJoyas repositoryJoyas) {
        this.repositoryJoyas = repositoryJoyas;
    }

    @Override
    public String createJoya(JoyaDTO joyaDTO) {

        if(joyaDTO == null) {
            return "No se puede crear una joya inexistente";
        }

        Joya joya = mapper.convertValue(joyaDTO, Joya.class);

        repositoryJoyas.save(joya);

        return "Nro identificatorio de joya creada: " + joya.getNro_identificatorio();
    }

    @Override
    public List<JoyaDTO> getJoyas() {
        List<Joya> joyaList = repositoryJoyas.findAll().stream().filter(Joya::isVentaONo).toList();
        return joyaList.stream().map(j -> mapper.convertValue(j, JoyaDTO.class)).collect(Collectors.toList());
    }

    @Override
    public JoyaDTO getJoyaById(Long id) {
        Joya joya = repositoryJoyas.findById(id).orElse(null);

        if(joya == null){
            throw new NotFoundException("No se encontró la joya deseada");
        }

        return mapper.convertValue(joya, JoyaDTO.class);
    }

    @Override
    public JoyaDTO updateJoya(Long id, JoyaDTO joyaDTO) {
        Joya joya = repositoryJoyas.findById(id).orElse(null);

        if(joya == null) {
            throw new NotFoundException("No se encontró la joya");
        }

        joya.setNombre(joyaDTO.getNombre());
        joya.setMaterial(joyaDTO.getMaterial());
        joya.setPeso(joyaDTO.getPeso());
        joya.setParticularidad(joyaDTO.getParticularidad());
        joya.setPoseePiedra(joyaDTO.isPoseePiedra());
        joya.setVentaONo(joyaDTO.isVentaONo());

        JoyaDTO update = mapper.convertValue(joya, JoyaDTO.class);

        this.createJoya(update);

        return update;
    }

    @Override
    public String deleteJoya(Long id) {
        Joya joya = repositoryJoyas.findById(id).orElse(null);

        if(joya == null) {
            throw  new NotFoundException("No se encontró la joya a eliminar");
        }

        joya.setVentaONo(false);

        JoyaDTO updated = mapper.convertValue(joya, JoyaDTO.class);

        this.createJoya(updated);
        return "Se eliminó la joya con éxito";
    }
}
