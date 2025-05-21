package com.showroom.extra.service;

import com.showroom.extra.dto.PrendaDTO;
import com.showroom.extra.model.Prenda;
import com.showroom.extra.repository.IPrendaRepository;
import com.showroom.extra.utils.PrendaMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrendaService implements IPrendaService{

    @Autowired
    private IPrendaRepository repository;

    public Prenda save(PrendaDTO prendaDTO){
        return repository.save(PrendaMapper.toPrenda(prendaDTO));
    }
    public List<Prenda> findAll(){
        return repository.findAll();
    }
    public Optional<Prenda> findById(String codigo){
        return repository.findById(codigo);
    }

    public Prenda updatePrenda(String codigo, PrendaDTO prendaDTO){
        Optional<Prenda> optionalPrenda = repository.findById(codigo);

        if (optionalPrenda.isPresent()) {
            Prenda prenda = optionalPrenda.get();

            prenda.setNombre(prendaDTO.getNombre());
            prenda.setTipo(prendaDTO.getTipo());
            prenda.setMarca(prendaDTO.getMarca());
            prenda.setColor(prendaDTO.getColor());
            prenda.setCantidad(prendaDTO.getCantidad());
            prenda.setTalle(prendaDTO.getTalle());
            prenda.setPrecioVenta(prendaDTO.getPrecioVenta());

            return repository.save(prenda);
        } else {
            throw new EntityNotFoundException("Prenda con código " + codigo + " no encontrada.");
        }
    }

    public String delete(String codigo){
        repository.deleteById(codigo);
        return "Prenda con Codigo: "+codigo + " Eliminado";
    }

    public List<Prenda> findByTalle(String talle){
        return repository.findAllByTalle(talle);
    }

    public List<Prenda> findByRemera(String nombre){
        return repository.findByNombreContainingIgnoreCase(nombre);
    }

}
