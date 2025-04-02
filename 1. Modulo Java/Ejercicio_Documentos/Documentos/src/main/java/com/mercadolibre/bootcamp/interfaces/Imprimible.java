package com.mercadolibre.bootcamp.interfaces;

import com.mercadolibre.bootcamp.model.Documento;

public interface Imprimible {
    static void imprimirDocumento(Documento documento) {
        documento.imprimir();
    };
}
