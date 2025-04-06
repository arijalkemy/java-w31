package co.com.mercadolibre.socorristas;

import co.com.mercadolibre.Auto;
import co.com.mercadolibre.Moto;

public class SocorristaAuto {

    public void socorrer(Auto auto){
        System.out.println("Socorriendo el auto con patente: " + auto.getPatente());
    }
}
