package org.example.manejoexcepcionesp1.service;

import org.example.manejoexcepcionesp1.dto.EntradaBlogDto;

import java.util.List;

public interface IEntradaBlogService {
    String crearEntradaBlog(EntradaBlogDto entradaBlogDto);
    EntradaBlogDto buscarEntradaBlogPorId(int id);
    List<EntradaBlogDto> listarEntradaBlog();
}
