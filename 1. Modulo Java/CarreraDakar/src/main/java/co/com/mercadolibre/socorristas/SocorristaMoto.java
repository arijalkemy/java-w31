package co.com.mercadolibre.socorristas;

import co.com.mercadolibre.Auto;
import co.com.mercadolibre.Moto;

public class SocorristaMoto {

    public void socorrer(Moto moto){
        System.out.println("Socorriendo el auto con patente: " + moto.getPatente());
    }
}
