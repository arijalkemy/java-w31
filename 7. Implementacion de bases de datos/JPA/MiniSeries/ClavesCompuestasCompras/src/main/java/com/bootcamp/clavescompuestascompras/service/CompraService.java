package com.bootcamp.clavescompuestascompras.service;

import com.bootcamp.clavescompuestascompras.entity.Compra;
import com.bootcamp.clavescompuestascompras.repository.CompraRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CompraService {
    private final CompraRepository repository;

    public CompraService(CompraRepository repository) {
        this.repository = repository;
    }

    public Compra saveCompra(Long clienteId, LocalDate fecha, String producto, int cantidad, double precio) {
        Compra compra = new Compra();
        compra.setClienteId(clienteId);
        compra.setFecha(fecha);
        compra.setProducto(producto);
        compra.setCantidad(cantidad);
        compra.setPrecio(precio);
        return repository.save(compra);
    }

    public List<Compra> getAllCompras() {
        return repository.findAll();
    }
}
