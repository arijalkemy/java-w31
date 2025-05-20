package org.mercadolibre.obras_literarias.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.mercadolibre.obras_literarias.dto.ObraLiterariaDTO;
import org.mercadolibre.obras_literarias.entity.ObraLiteraria;
import org.mercadolibre.obras_literarias.repository.ObraLiterariaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ObraLiterariaServiceImpl implements ObraLiterariaService{

    final private ObraLiterariaRepository repository;
    ObjectMapper mapper = new ObjectMapper();

    public ObraLiterariaServiceImpl(ObraLiterariaRepository repository) {
        this.repository = repository;
    }

    @Override
    public ObraLiterariaDTO createObraLiteraria(ObraLiterariaDTO dto) {
        ObraLiteraria obraLiteraria = new ObraLiteraria();
        obraLiteraria.setNombre(dto.getNombre());
        obraLiteraria.setAutor(dto.getAutor());
        obraLiteraria.setCantPaginas(dto.getCantPaginas());
        obraLiteraria.setEditorial(dto.getEditorial());
        obraLiteraria.setAnioPublicacion(dto.getAnioPublicacion());

        System.out.println(obraLiteraria);

        repository.save(obraLiteraria);
        return dto;
    }

    @Override
    public List<ObraLiterariaDTO> getAllObrasLiterarias() {

        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(ol -> mapper.convertValue(ol, ObraLiterariaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ObraLiterariaDTO> createMultipleObrasLiterarias(List<ObraLiterariaDTO> dtoList) {
        List<ObraLiteraria> obraLiterarias = dtoList.stream()
                .map(ol -> mapper.convertValue(ol, ObraLiteraria.class)).toList();

        repository.saveAll(obraLiterarias);

        return dtoList;
    }
}
