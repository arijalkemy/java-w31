package com.mercadolibre.elasticsearch2.service;

import com.mercadolibre.elasticsearch2.dto.ObraLiterariaDto;
import com.mercadolibre.elasticsearch2.model.ObraLiteraria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IObraLiterariaService {
    ObraLiterariaDto save(ObraLiterariaDto obraLiteraria);
    List<ObraLiterariaDto> getByAutor(String autor);
    List<ObraLiterariaDto> getByNombre(String nombre);
    List<ObraLiterariaDto> getByEditorial(String editorial);
    List<ObraLiterariaDto> getTop5MasPaginas();
    List<ObraLiterariaDto> getPublicadasAntesDelAnio(Integer anio);
}
