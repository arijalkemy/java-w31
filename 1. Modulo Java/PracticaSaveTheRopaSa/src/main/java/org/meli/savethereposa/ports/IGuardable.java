package org.meli.savethereposa.ports;

import org.meli.savethereposa.domain.Prenda;

import java.util.List;

public interface IGuardable {

    /*
    Devuelve un numero de identificador que servirá para mostrar la prenda (es el identificador de la prenda
    a mostrar
     */
    Integer guardarPrenda(List<Prenda> listaDePrenda);
}
