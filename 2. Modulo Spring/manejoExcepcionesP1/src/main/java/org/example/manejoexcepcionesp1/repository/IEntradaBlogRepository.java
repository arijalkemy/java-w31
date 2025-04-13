package org.example.manejoexcepcionesp1.repository;
import org.example.manejoexcepcionesp1.entity.EntradaBlog;

import java.util.List;

public interface IEntradaBlogRepository {
    void crearEntradaBlog(EntradaBlog entradaBlog);
    List<EntradaBlog> buscarEntradaBlogPorId(int id);
    List<EntradaBlog> listarEntradaBlog();
}
