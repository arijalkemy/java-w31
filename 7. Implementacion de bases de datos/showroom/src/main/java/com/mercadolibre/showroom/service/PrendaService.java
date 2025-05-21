package com.mercadolibre.showroom.service;

import com.mercadolibre.showroom.dto.request.PrendaRequestDto;
import com.mercadolibre.showroom.dto.response.PrendaResponseDto;
import com.mercadolibre.showroom.exception.BadRequest;
import com.mercadolibre.showroom.model.Prenda;
import com.mercadolibre.showroom.repository.PrendaRepository;
import com.mercadolibre.showroom.utils.GlobalMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PrendaService implements IPrendaService{
    private final PrendaRepository prendaRepository;

    @Override
    public PrendaResponseDto addPrenda(PrendaRequestDto prendaRequest){
        if(existByCodigo(prendaRequest)){
            throw new BadRequest("Ya existe una prenda con ese codigo: " + prendaRequest.getCodigo());
        }
        Prenda prenda = GlobalMapper.dtoToentity(prendaRequest);
        prendaRepository.save(prenda);

        return GlobalMapper.entityToDto(prenda);
    }

    @Override
    public List<PrendaResponseDto> getAll(){
        List<Prenda> prendaList = prendaRepository.findAll();
        if(prendaList.isEmpty()){
            throw new BadRequest("No hay ninguna prenda");
        }
        return GlobalMapper.listEntityToDto(prendaList);
    }

    @Override
    public PrendaResponseDto getByCodigo(String codigo){
        Prenda prenda = findByCodigo(codigo);
        return GlobalMapper.entityToDto(prenda);
    }

    @Override
    public PrendaResponseDto updatePrenda(String codigo, PrendaRequestDto prendaRequest){
        Prenda prendaDb = findByCodigo(codigo);
        prendaRepository.save(GlobalMapper.updateEntityFromDto(prendaDb, prendaRequest));
        return GlobalMapper.entityToDto(prendaDb);
    }

    @Override
    public void deleteByCodigo(String codigo){
        Prenda prendaDb = findByCodigo(codigo);
        prendaRepository.deleteById(prendaDb.getId());
    }

    @Override
    public List<PrendaResponseDto> getAllByTalle(String talle){
        List<Prenda> prendasTalle = findAllByTalle(talle);
        if (prendasTalle.isEmpty()){
            throw new BadRequest("No hay prendas con ese talle: " + talle);
        }

        return GlobalMapper.listEntityToDto(prendasTalle);
    }

    @Override
    public List<PrendaResponseDto> getByExistNombre(String nombre){
        List<Prenda> prendasNombre = findByContainNombre(nombre);
        if(prendasNombre.isEmpty()){
            throw new BadRequest("No se encontraron prendas con ese nombre: " + nombre);
        }

        return GlobalMapper.listEntityToDto(prendasNombre);
    }



    /*+++++++++++++++
     PRIVATE METHODS
    ++++++++++++++++*/
    private boolean existByCodigo(PrendaRequestDto prendaRequest){
        return prendaRepository.existsPrendaByCodigo(prendaRequest.getCodigo());
    }

    @Override
    public Prenda findByCodigo(String codigo){
        return prendaRepository.findByCodigo(codigo)
                .orElseThrow(()-> new BadRequest("No se encontraron prendas con el codigo: " + codigo));
    }

    private List<Prenda> findByContainNombre(String nombre){
        return prendaRepository.findByNombreContainingIgnoreCase(nombre);
    }

    private List<Prenda> findAllByTalle(String talle){
        return prendaRepository.findAllByTalle(talle);
    }
}
