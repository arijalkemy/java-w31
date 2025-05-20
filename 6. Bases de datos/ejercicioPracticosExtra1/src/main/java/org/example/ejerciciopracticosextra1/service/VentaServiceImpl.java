package org.example.ejerciciopracticosextra1.service;

import org.example.ejerciciopracticosextra1.model.Prenda;
import org.example.ejerciciopracticosextra1.model.Venta;
import org.example.ejerciciopracticosextra1.repository.IPrendaRepository;
import org.example.ejerciciopracticosextra1.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VentaServiceImpl implements IVentaService{
    private final IVentaRepository ventaRepository;
    private final IPrendaRepository prendaRepository;

    @Autowired
    public VentaServiceImpl(IVentaRepository ventaRepository, IPrendaRepository prendaRepository) {
        this.ventaRepository = ventaRepository;
        this.prendaRepository = prendaRepository;
    }

    @Override
    public List<Venta> getVentas(){
        return (List<Venta>) this.ventaRepository.findAll();
    }

    @Override
    public Venta getVentaByNumero(Long numero){
        return this.ventaRepository.getVentaByNumero(numero);
    }

    @Override
    public List<Prenda> getPrendasByFecha(Date fecha){
        return this.prendaRepository.getPrendasByFecha(fecha);
    }

    @Override
    public List<Prenda> getPrendasByNumero(Long numero){
        return this.prendaRepository.getPrendasByNumero(numero);
    }

    @Override
    public void createVenta(Venta venta){
        this.ventaRepository.save(venta);
    }

    @Override
    public void updateVenta(Long numero, Venta venta){
        Venta ventaEncontrada = this.ventaRepository.getVentaByNumero(numero);
        ventaEncontrada.setFecha(venta.getFecha());
        ventaEncontrada.setTotal(venta.getTotal());
        ventaEncontrada.setMedioPago(venta.getMedioPago());
        ventaEncontrada.setPrendas(venta.getPrendas());
        this.ventaRepository.save(ventaEncontrada);
    }

    @Override
    public void deleteVenta(Long numero){
        this.ventaRepository.deleteByNumero(numero);
    }
}
