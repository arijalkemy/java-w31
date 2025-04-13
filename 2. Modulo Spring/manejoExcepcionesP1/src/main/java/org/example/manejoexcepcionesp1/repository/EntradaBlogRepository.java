package org.example.manejoexcepcionesp1.repository;

import org.example.manejoexcepcionesp1.dto.EntradaBlogDto;
import org.example.manejoexcepcionesp1.entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EntradaBlogRepository implements IEntradaBlogRepository{

    List<EntradaBlog> entradaBlogList = new ArrayList<>();

    public void crearEntradaBlog(EntradaBlog entradaBlog){
        this.entradaBlogList.add(entradaBlog);
    };

    public List<EntradaBlog> buscarEntradaBlogPorId(int id){
        return this.entradaBlogList.stream().filter(entradaBlog ->
                entradaBlog.getId()==id).toList();
    }

    public List<EntradaBlog> listarEntradaBlog(){
        return entradaBlogList;
    };
}
