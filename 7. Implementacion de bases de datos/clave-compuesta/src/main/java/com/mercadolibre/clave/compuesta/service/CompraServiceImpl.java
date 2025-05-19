package com.mercadolibre.clave.compuesta.service;

import com.mercadolibre.clave.compuesta.entity.CompraClienteId;
import com.mercadolibre.clave.compuesta.repository.ICompraRepository;
import org.springframework.stereotype.Service;

@Service
public class CompraServiceImpl implements ICompraService{

    private final ICompraRepository compraRepository;

    public CompraServiceImpl(ICompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }



    @Override
    public CompraClienteId create(CompraClienteId compra){
        return compraRepository.save(compra);


    }

}
