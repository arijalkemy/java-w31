package org.example.manejoexcepcionesp1.service;

import org.example.manejoexcepcionesp1.dto.EntradaBlogDto;
import org.example.manejoexcepcionesp1.exception.NotFoundException;
import org.example.manejoexcepcionesp1.exception.RepetidoException;
import org.example.manejoexcepcionesp1.mapper.EntradaBlogMapper;
import org.example.manejoexcepcionesp1.repository.EntradaBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntradaBlogServiceImpl {

    @Autowired
    EntradaBlogRepository entradaBlogRepository;

    public String crearEntradaBlog(EntradaBlogDto entradaBlogDto){
        if(entradaBlogRepository.listarEntradaBlog().stream().filter(entradaBlog ->
                entradaBlog.getId()==entradaBlogDto.getId()).toList().isEmpty()){
            entradaBlogRepository.crearEntradaBlog(EntradaBlogMapper.dtoToEntity(entradaBlogDto));
            return "Se ha creado correctamente la entrada del blog con id: "+entradaBlogDto.getId();
        }else{
            throw new RepetidoException("Ya existe una entrada del blog con ese id.");
        }
    }

    public EntradaBlogDto buscarEntradaBlogPorId(int id){
        if(entradaBlogRepository.buscarEntradaBlogPorId(id).isEmpty()){
            throw new NotFoundException("No se ha encontrado la entrada blog con id: "+id);
        }else{
            return EntradaBlogMapper.entityToDto(entradaBlogRepository.buscarEntradaBlogPorId(id).get(0));
        }
    }

    public List<EntradaBlogDto> listarEntradaBlog(){
        if(entradaBlogRepository.listarEntradaBlog().stream().
                map(EntradaBlogMapper::entityToDto).toList().isEmpty()){
            throw new NotFoundException("La lista de entrada blog está vacía");
        }else{
            return entradaBlogRepository.listarEntradaBlog().stream().
                    map(EntradaBlogMapper::entityToDto).toList();
        }
    }
}
