package com.bootcamp.clavescompuestascompras.controller;

import com.bootcamp.clavescompuestascompras.entity.Compra;
import com.bootcamp.clavescompuestascompras.service.CompraService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/compras")
public class CompraController {
    private final CompraService service;

    public CompraController(CompraService service) {
        this.service = service;
    }

    @PostMapping("/new")
    public Compra createCompra(@RequestParam Long clienteId, @RequestParam String fecha,
                               @RequestParam String producto, @RequestParam int cantidad, @RequestParam double precio) {
        LocalDate parsedDate = LocalDate.parse(fecha);
        return service.saveCompra(clienteId, parsedDate, producto, cantidad, precio);
    }

    @GetMapping
    public List<Compra> getAllCompras() {
        return service.getAllCompras();
    }
}
