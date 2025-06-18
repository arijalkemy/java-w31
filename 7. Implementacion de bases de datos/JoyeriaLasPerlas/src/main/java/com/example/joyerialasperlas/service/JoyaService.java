package com.example.joyerialasperlas.service;

import com.example.joyerialasperlas.dto.JoyaDTO;
import com.example.joyerialasperlas.model.Joya;
import com.example.joyerialasperlas.repository.JoyaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JoyaService implements IJoyaService{

    private final JoyaRepository joyaRepo;
    private final ObjectMapper mapper;

    public JoyaService(JoyaRepository joyaRepo) {
        this.joyaRepo = joyaRepo;
        this.mapper = new ObjectMapper();

    }

    @Override
    public List<JoyaDTO> getJoyas() {
        return joyaRepo.findAll().stream().map(j -> mapper.convertValue(j, JoyaDTO.class)).toList();
    }

    @Override
    public String saveJoya(JoyaDTO joya) {
        Joya newJoya = mapper.convertValue(joya, Joya.class);
        Joya adedJoya = joyaRepo.save(newJoya);
        return "Se creo la joya exitosamente con el id: " + adedJoya.getId();
    }

    @Override
    public List<JoyaDTO> deleteJoya(Long id) {
        List<JoyaDTO> joyaDTOList = new ArrayList<>();
        Joya joya = joyaRepo.findById(id).orElse(null);
        if( joya == null || joya.getVentaONo().equals(false)){ return joyaDTOList;}
        joya.setVentaONo(false);
        joyaRepo.save(joya);

        List<Joya> joyaList = joyaRepo.findAll();
        joyaDTOList = joyaList.stream().map(j -> mapper.convertValue(j, JoyaDTO.class)).toList();
        return joyaDTOList;
    }

    @Override
    public JoyaDTO findJoya(Long id) {
        Joya joya = joyaRepo.findById(id).orElse(null);
        return mapper.convertValue(joya, JoyaDTO.class);
    }

    @Override
    public JoyaDTO modifyJoya(Long id, JoyaDTO newJoya) {
        Joya joya = joyaRepo.findById(id).orElse(null);
        if(joya != null){
            joya.setPeso(newJoya.getPeso());
            joya.setNombre(newJoya.getNombre());
            joya.setMaterial(newJoya.getMaterial());
            joya.setParticularidad(newJoya.getParticularidad());
            joya.setPoseePidra(newJoya.getPoseePidra());
            joya.setVentaONo(newJoya.getVentaONo());
            joyaRepo.save(joya);
        }
        return mapper.convertValue(joya, JoyaDTO.class);
    }

}
