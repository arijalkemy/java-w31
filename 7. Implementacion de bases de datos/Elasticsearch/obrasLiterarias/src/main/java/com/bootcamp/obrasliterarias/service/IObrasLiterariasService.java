package com.bootcamp.obrasliterarias.service;

import java.util.List;
import com.bootcamp.obrasliterarias.dto.ObraLiterariaDto;

public interface IObrasLiterariasService {
    public List<ObraLiterariaDto> getAllObrasLiterarias();

    public String createObraLiteraria(ObraLiterariaDto obraLiterariaDto);

    public List<ObraLiterariaDto> getObrasLiterariasByAutor(String autor);

    public List<ObraLiterariaDto> getObrasLiterariasByKeyword(String keyword);

    public List<ObraLiterariaDto> getFiveLongestObrasLiterarias();

    public List<ObraLiterariaDto> getObrasLiterariasBeforeYear(Integer year);

    public List<ObraLiterariaDto> getObrasLiterariasByEditorial(String editorial);
}
