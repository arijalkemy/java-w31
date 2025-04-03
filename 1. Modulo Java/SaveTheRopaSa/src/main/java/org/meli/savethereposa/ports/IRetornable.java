package org.meli.savethereposa.ports;

import org.meli.savethereposa.domain.Prenda;

import java.util.List;

public interface IRetornable{


    /*
    Devuelve la lista de prendas que están guardadas bajo ese número.
     */
    List<Prenda> devolverPrendas(Integer numero);
}
