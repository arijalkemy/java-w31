package com.mercadolibre.clave.compuesta.controller;

import com.mercadolibre.clave.compuesta.entity.CompraClienteId;
import com.mercadolibre.clave.compuesta.service.ICompraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compra")
public class CompraController {


    private final ICompraService compraService;

    public CompraController(ICompraService compraService) {
        this.compraService = compraService;
    }


    @PostMapping
    public ResponseEntity<CompraClienteId> create(@RequestBody CompraClienteId compra){

    }
}
