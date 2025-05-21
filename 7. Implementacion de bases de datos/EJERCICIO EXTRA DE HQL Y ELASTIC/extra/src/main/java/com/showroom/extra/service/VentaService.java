package com.showroom.extra.service;

import com.showroom.extra.dto.VentaDTO;
import com.showroom.extra.model.Prenda;
import com.showroom.extra.model.Venta;
import com.showroom.extra.repository.IPrendaRepository;
import com.showroom.extra.repository.IVentaRepository;
import com.showroom.extra.utils.PrendaMapper;
import com.showroom.extra.utils.VentaMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VentaService implements IVentaService{

    @Autowired
    private IVentaRepository repository;

    @Autowired
    private IPrendaRepository repoPrenda;

    public Venta save(VentaDTO ventaDTO){
        List<Long> listIdPrenda = ventaDTO.getPrendasId();
        List<Prenda> prendaList = new ArrayList<>();

        for(Long id: listIdPrenda){
            Optional<Prenda> p = repoPrenda.findById(id);
            if(p.isPresent()){
                prendaList.add(p.get());
            }
        }

        Venta v = new Venta();

        v.setPrendas(prendaList);
        v.setFecha(ventaDTO.getFecha());
        v.setMedioPago(ventaDTO.getMedioPago());
        v.setTotal(ventaDTO.getTotal());

        return  repository.save(v);

    }

    public List<Venta> findAll(){
        return repository.findAll();
    }

    public Optional<Venta> findbyId(Long id){
        return repository.findById(id);
    }

    public Venta updateSale(Long id,VentaDTO ventaDTO){
        Optional<Venta> ventaOptional= repository.findById(id);
        if (ventaOptional.isPresent()){
            Venta v = new Venta();
            v = ventaOptional.get();

            v.setMedioPago(ventaDTO.getMedioPago());
            v.setFecha(ventaDTO.getFecha());
            v.setTotal(ventaDTO.getTotal());

            List<Long> listIdPrenda = ventaDTO.getPrendasId();
            List<Prenda> prendaList = new ArrayList<>();

            for(Long codigo: listIdPrenda){
                Optional<Prenda> p = repoPrenda.findById(codigo);
                if(p.isPresent()){
                    prendaList.add(p.get());
                }
            }

            v.setPrendas(prendaList);

            return v;
        }
        throw new EntityNotFoundException("No se encontro venta");
    }

    public String deleteSale(Long id){
        Optional<Venta> ventaOptional = repository.findById(id);

        if(!ventaOptional.isPresent()){
           throw new EntityNotFoundException("No se encotro venta");
        }
        repository.delete(ventaOptional.get());
        return "Eliminado exitosamente";
    }

    public List<Venta> saleByFecha(LocalDate date){
        return repository.findAllByFecha(date);
    }

    public List<Prenda> findBySale(Long id){
        return repository.findById(id).get().getPrendas();
    }



}
