package org.example.ejerciciopracticosextra1.service;
import org.example.ejerciciopracticosextra1.model.Prenda;
import org.example.ejerciciopracticosextra1.repository.IPrendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrendaServiceImpl implements IPrendaService{

    private final IPrendaRepository prendaRepository;

    @Autowired
    public PrendaServiceImpl(IPrendaRepository prendaRepository) {
        this.prendaRepository = prendaRepository;
    }

    @Override
    public List<Prenda> getAllPrendas(){
        return this.prendaRepository.getAllPrendas();
    }

    @Override
    public Prenda getPrendaByCodigo(String codigo){
        return this.prendaRepository.getPrendaByCodigo(codigo);
    }

    @Override
    public List<Prenda> getPrendaByTalla(Prenda.Talla talla){
        return this.prendaRepository.getPrendaByTalla(talla);
    }

    @Override
    public List<Prenda> getPrendaByNombre(String nombre){
        return this.prendaRepository.getPrendaByNombre(nombre);
    }

    @Override
    public void createPrenda(Prenda prenda){
        this.prendaRepository.save(prenda);
    }

    @Override
    public void updatePrenda(String codigo, Prenda prenda){
        Prenda prendaEncontrada = this.getPrendaByCodigo(codigo);
        prendaEncontrada.setNombre(prenda.getNombre());
        prendaEncontrada.setTipo(prenda.getTipo());
        prendaEncontrada.setMarca(prenda.getMarca());
        prendaEncontrada.setColor(prenda.getColor());
        prendaEncontrada.setTalla(prenda.getTalla());
        prendaEncontrada.setCantidad(prenda.getCantidad());
        prendaEncontrada.setPrecioVenta(prenda.getPrecioVenta());
        this.prendaRepository.save(prendaEncontrada);
    }

    @Override
    public void deletePrenda(String codigo){
        this.prendaRepository.deleteByCodigo(codigo);
    }
}
